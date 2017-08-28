import java.util.Iterator;
// This is the test class to add acch each child into the list, of rap, rock or pop.
/**
 * @author Demarco Ewings
 * CS 220 Tree Search Program
 **/
public class Test {

    public static void main(String s[]){
    	  GeneralTree<String> generalTree=new GeneralTree<String>("MUSIC");
    	 // Tree t = new Tree("Music");
    	  Position<String> rap= generalTree.addChild(generalTree.root(), "RAP");
    	  Position<String> rock= generalTree.addChild(generalTree.root(), "ROCK");
    	  Position<String> pop= generalTree.addChild(generalTree.root(), "POP");

    	  generalTree.addChild(rap,"R1 - Lil Wayne");
    	  generalTree.addChild(rap,"R2 - J. Cole");
    	  generalTree.addChild(rap,"R3 - Drake");
    	  generalTree.addChild(rap,"R4 - Chance The Rapper");
    	  generalTree.addChild(rap,"R5 - Nicki Minaj");
    	  generalTree.addChild(rap,"R6 - Kanye West");
    	  generalTree.addChild(rap,"R7 - Wale");

    	  generalTree.addChild(rock,"R11 - The Dead Wheather");
    	  generalTree.addChild(rock,"R21 - Paramore");
    	  generalTree.addChild(rock,"R31 - Cold Play");
    	  generalTree.addChild(rock,"R41 - Gren Day");
    	  generalTree.addChild(rock,"R51 - Florence & The Machine");
    	  generalTree.addChild(rock,"R61 - The Script");
    	  generalTree.addChild(rock,"R71 - Imagine Dragons");

    	  generalTree.addChild(pop,"P1 - Adele");
    	  generalTree.addChild(pop,"P2 - Lady Gaga");
    	  generalTree.addChild(pop,"P3 - Sia");
    	  generalTree.addChild(pop,"P4 - Calvin Harris");
    	  generalTree.addChild(pop,"P5 - Michael Jackson");
    	  generalTree.addChild(pop,"p6 - Beyonce");
    	  generalTree.addChild(pop,"P7 - Justin Timberlake ");

    	  Iterator<Position<String>> iterator;

    	  iterator=generalTree.iterator();
   	      while (iterator.hasNext()){
   		   System.out.println (iterator.next().toString());
   	      }

    	  Iterator<? extends Position<String>> iterator1= generalTree.children(rap).iterator();

    	    while (iterator1.hasNext()){
     		   System.out.println ("=====RAP CHILD LIST======"+iterator1.next().toString());
     	   }

    	    Iterator<? extends Position<String>> iterator2= generalTree.children(rock).iterator();

    	    while (iterator2.hasNext()){
     		   System.out.println ("=====ROCK CHILD LIST======"+iterator2.next().toString());
     	   }

    	    Iterator<? extends Position<String>> iterator3= generalTree.children(pop).iterator();

    	    while (iterator3.hasNext()){
     		   System.out.println ("=====POP CHILD LIST======"+iterator3.next().toString());
     	   }





    }

}
