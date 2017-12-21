import java.awt.*;
import java.util.Arrays;
import jm.util.*;
import jm.music.*;
import jm.music.data.*;
import jm.JMC;
import jm.util.Play;

public class Sorting implements JMC {
	//Pitch Matcher: corresponds a number value for an array of notes with a given pitch
	public static int playPitches(int pitches) {
		if(pitches == 0)
			pitches = A1;
		else if(pitches == 1)
			pitches = C1;
		else if(pitches == 2)
			pitches = D1;
		else if(pitches == 3)
			pitches = E1;
		else if(pitches == 4)
			pitches = G1;
		else if(pitches == 5)
			pitches = A2;
		else if(pitches == 6)
			pitches = C2;
		else if(pitches == 7)
			pitches = D2;
		else if(pitches == 8)
			pitches = E2;
		else if(pitches == 9)
			pitches = G2;
		return pitches;
	}
	
	//Insertion Sort: sorts an array of integers in ascending order in int[] arrayTen
	public static void insertionSort(int[] data) {
		for(int i = 0; i < data.length-1; i++) {
			int j = i+1;
			int temp = data[j];
			while(j > 0 && temp < data[j-1]) {
				data[j] = data[j-1];
				j--;
				data[j] = temp;
			}
			System.out.println(Arrays.toString(data));
			
			Phrase selectionPhrase = new Phrase(0.0);

			//for every time an integer value is sorted in the array, it adds a note to be played
			for(int k = 0; k < data.length; k++) {
				int pitches = playPitches(data[k]);
				Note randNote = new Note(pitches, SN, 100, 0.5);
				selectionPhrase.addNote(randNote);
			}
		    
			Note restNote = new Note(REST, WN, 100, 0.5);
			selectionPhrase.addNote(restNote);
			Part pianoPart1 = new Part("Piano", PIANO, 0);
			pianoPart1.addPhrase(selectionPhrase);
			Play.midi(selectionPhrase);
		}
	}

	//makeRandomIntArray Method: fills an array of ten integers with random numbers 0-9 in int[] arrayTen
		public static int[] makeRandomIntArray1(int arrayTen) {
			int[] data = new int[arrayTen];
			for(int i = 0; i < arrayTen; i++) {
				data[i] = (int)(Math.random()*arrayTen);
			}
			return data;
		}
	
	//Selection Sort: sorts an array of notes to the corresponding integer value in int[] notes
	public static void selectionSort(int[] notes) {
		for(int i = 0; i < notes.length - 1; i++) {
            int index = i;
            for(int j = i + 1; j < notes.length; j++)
                if (notes[j] < notes[index]) 
                    index = j;
      
            int temp = notes[index];  
            notes[index] = notes[i];
            notes[i] = temp;
        }
     
        Phrase pianoPhrase = new Phrase(0.0);
		Part pianoPart2 = new Part("Piano", PIANO, 1);
    	int[] pianoPitches = {A1, C1, D1, E1, G1, A2, C2, D2, E2, G2};
    	double[] durations = {QN, QN, QN, QN, QN, QN, QN, QN, QN, QN};
		
	    for(int k = 0; k < notes.length; k++) {
	    	pianoPhrase.addNote(new Note(pianoPitches[k], durations[k]));
	    	pianoPart2.addPhrase(pianoPhrase);
	    	Play.midi(pianoPhrase);
	    }
	}
	
	//makeRandomIntArray2 Method: fills an array of ten integers with random numbers 0-9 in int[] notes
	public static int[] makeRandomIntArray2(int notes) {
		int[] data = new int[notes];
		for(int i = 0; i < notes; i++) {
			data[i] = (int)(Math.random()*notes);
		}
		return data;
	}
		
	//main method: computes the above methods by printing the original arrays, step-by-step, until it is sorted
	public static void main(String[] args) {
		int[] arrayTen = makeRandomIntArray1(10);
		int[] notes = makeRandomIntArray2(10);
		
		System.out.println("Original Array[arrayTen]: " + Arrays.toString(arrayTen));
		insertionSort(arrayTen);
		System.out.println("Sorted Array[arrayTen]: " + Arrays.toString(arrayTen));
		System.out.println("Original Array[notes]: " + Arrays.toString(notes));
		selectionSort(notes);
		System.out.println("Sorted Array[notes]: " + Arrays.toString(notes));
	}
}	