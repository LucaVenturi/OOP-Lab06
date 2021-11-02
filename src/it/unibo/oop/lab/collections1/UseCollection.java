package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private static final int ELEMS = 100_000;

	private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    	
    	//1)
    	List<Integer> arrList = new ArrayList<Integer>();
    	
    	for(int i = 1000; i < 2000; i++) {
    		arrList.add(i);
    	}
    	
    	//2)
    	List<Integer> linkList = new LinkedList<Integer>();
    	linkList.addAll(arrList);
    	
    	//3)
    	final int tmp = arrList.get(arrList.size() - 1);
    	
    	arrList.set(arrList.size() - 1, arrList.get(0));
    	arrList.set(0, tmp);
    	
    	//4)
    	for(final int i : arrList) {
    		System.out.println(i);
    	}
    	
    	//5)
        long timeArr = System.nanoTime();

        for (int i = 0; i < ELEMS; i++) {
            arrList.add(0, i);
        }
        
        timeArr = System.nanoTime() - timeArr;
        
        //----------
        
        long timeLink = System.nanoTime();
        
        for (int i = 0; i < ELEMS; i++) {
        	linkList.add(0, i);
        }
        
        timeLink = System.nanoTime() - timeLink;
        
        System.out.println("ArrayList: " + timeArr + "\tLinkedList: " + timeLink);
        
        //6)
        timeArr = System.nanoTime();

        for (int i = 0; i < ELEMS; i++) {
            arrList.get(arrList.size() / 2);
        }
        
        timeArr = System.nanoTime() - timeArr;
        
        //----------
        
        timeLink = System.nanoTime();
        
        for (int i = 0; i < ELEMS; i++) {
        	linkList.get(linkList.size() / 2);
        }
        
        timeLink = System.nanoTime() - timeLink;
        
        System.out.println("ArrayList: " + timeArr + "\tLinkedList: " + timeLink);
        
        //8)
        long worldPopulation = 0;
        Map<String,Long> map = new HashMap<String,Long>();
        
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 972_005_000L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);
        map.put("Antarctica", 0L);
        
        for ( final long l : map.values() ) {
        	worldPopulation += l;
        }
        
        System.out.println(worldPopulation);
    }
}
