package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	AccountHolder tom = new AccountHolder("Tom", "Ford", 1);
    	AccountHolder mike = new AccountHolder("Mike", "Tyson", 2);
    	
    	BankAccount tomBA = new StrictBankAccount(1, 10_000, 10);
    	BankAccount mikeBA = new StrictBankAccount(2, 10_000, 10);
    	
    	try {
    		//Wrong User, should fail.
    		tomBA.deposit(mike.getUserID(), 5_000);
    		
    		//Assert it failed.
    		Assert.fail("Wrong User");
    		
    	} catch (WrongAccountHolderException e) {
    		assertNotNull(e);
    		System.out.println(e.getMessage());
    	}
    	
    	try {
    		//Not enough money, should fail.
    		tomBA.withdraw(tom.getUserID(), 50_000);
    		
    		//Assert it failed.
    		Assert.fail("Not enough money bro");
    		
    	} catch (NotEnoughFoundsException | WrongAccountHolderException e) {
    		assertNotNull(e);
    		System.out.println(e.getMessage());
    	}
    	
    	//Deposit 10 times from ATK, shouldn't fail.
    	for (int i = 0; i < 10; i++) {
            try {
            	mikeBA.depositFromATM(mike.getUserID(), 1);
            } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
                Assert.fail(e.getMessage());
            }
        }
    	
        try {
        	mikeBA.depositFromATM(tom.getUserID(), 1);
            Assert.fail("ATM transaction limit exceeded");
        } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
            assertNotNull(e);
            System.out.println(e.getMessage());
        }
    }
}
