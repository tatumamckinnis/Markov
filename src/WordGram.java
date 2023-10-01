
import java.util.ArrayList; 
/**
 * A WordGram object represents an immutable
 * sequence of words.
 * For use in Compsci 201, Duke University, Fall 2022
 * Add yourself as an author when you make edits
 * @author Brandon Fain
 * @author Owen Astrachan, revised Fall 2023
 * @author Tatum McKinnis
 */

public class WordGram {
    private String[] myWords;   // Stores WordGram words
    private String myToString;  // Stores space separated words as one string
    private int myHash;         // Stores hash value of WordGram

    
    /**
     * Constructor should generate a WordGram with size words
     * beginning at the start index value of source array.
     * Each element of source array should be a single word.
     * @param source Source array, each element should be a single word
     * @param start Index of first word for WordGram object
     * @param size Number of elements in WordGram object
     */
    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        int k = start;
                for(int i=0; i < size; i++) {
            myWords[i] = source[k];
            k++;
        }

        myToString = null; 
        myHash =0; 
    }


    /**
     * Returns number of words in this WordGram
     * @return order of wordgram, number of words
     */

    public int length() {
        // TODO correctly implement length 
        return myWords.length; 
    }
	public void changeWords(String [] newWords)
	{
		myWords = newWords;
	}

    /** 
     * Returns true if o is also a wordgram with the
     * same words, otherwise returns false 
    */
    @Override
    public boolean equals(Object o) {
        if (! (o instanceof WordGram) || o == null){
            return false;
        }
        WordGram other = (WordGram) o;
        // TODO complete correct implementation of equals (above is correct)
        if (other.length() != this.length())
        {
            return false; 
        }
        for (int i=0; i<myWords.length; i++)
        {
            if (other.getWord(i) != null )
            {

            
            if (other.getWord(i).equals(this.myWords[i]) == false)
            {
                return false;
            }
        }
        }
        return true;
    }
    public String getWord(int index)
    {
        return myWords[index];
    }

    /**
     * Returns a hashCode for WordGram object equal to 
     * the hashCode of the space separated words stored in 
     * the WordGram.
     */
    @Override
    public int hashCode() {
        // TODO correctly implement hashCode
        if (myHash ==0)
        {
        myHash = toString().hashCode();
        }
        return myHash;
    }

    /**
     * Return a new WordGram of the same length as this WordGram 
     * consisting of words 1 through length-1 of this WordGram
     * followed by last. Does NOT mutate this WordGram.
     * @param last added as last string of returned WordGram
     * Should be a single word
     * @return new WordGram
     */
    public WordGram shiftAdd(String last) {
        // TODO correctly implement shiftAdd
        WordGram wg = new WordGram(myWords, 0, length());
		ArrayList<String> list = new ArrayList<String>(); 
		for (int i =1; i<myWords.length; i++)
		{
			list.add(myWords[i]); 
		}
		list.add(last); 
		String [] newArray = new String [list.size()];
		list.toArray(newArray);
		wg.changeWords(newArray);

        //need to delete first one, shift others over, add one to end 
        //maybe use arraylist 

        return wg;
    }


    /**
     * Returns space separated words stored in the WordGram
     * as a single String.
     */
  
    @Override
	public String toString(){
		if (myToString == null) {
			myToString = String.join(" ",myWords);
		}
		return myToString;
    }
}

