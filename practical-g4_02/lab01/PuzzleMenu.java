import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class PuzzleMenu {

	static Grid grid = null;
	static ArrayList<WordInfo> wordList = null;

    public static void main(String[] args) throws FileNotFoundException{

		// error if user does not especify a file
		if(args.length != 1){
			System.err.println("Usage: java PuzzleMenu [file]");
			System.exit(1);
		}
		
		Read(args[0]);

		// write in file
		String file = String.format("results_%s", args[0]);
		PrintStream myFile = new PrintStream(new File(file));
		PrintStream console = System.out;
		System.setOut(myFile);

		// print all words to be found in the soup
		System.out.print("Palavras detetadas: ");
		for(int j = 0; j < wordList.size(); j++){
			System.out.printf("%s ",wordList.get(j).getWord());
		}
		System.out.println();

		// print original grid
		System.out.println("\nOriginal Grid");
		System.out.println(grid);


		Grid gridSolved = PuzzleSolver.solveGrid(grid, wordList.toArray(new WordInfo[wordList.size()]));

		// in case some word doesnt exist in the soup, it will print an error and close de program
		for (WordInfo word : wordList) {
			if(word.getCoords() == null){
			  System.err.printf("ERRO: Palavra %s não existente..\n", word.getWord());
			  System.exit(1);
			}
		}

		//print solved grid and list of words
		System.out.println(gridSolved);
		for (WordInfo word : wordList) {
			System.out.println(word);
		}

		System.setOut(console);
	
	}



	//
	// All related to Reading and validation
	// 

	public static void Read(String file){

		try {

			Scanner scanner = new Scanner(new File(file));

			//ya
			// init values
			int i = 0;
			String line;
			wordList = new ArrayList<WordInfo>();
			boolean first = true;
			int standard_len = 0;
			
			char[][] lines = null;

			int matrix_line_count = 0;


			while (scanner.hasNextLine()) {
				
				line = scanner.nextLine();

				// in case the line is empty, close de program
				if(line.trim().isEmpty()){
					System.err.println("ERRO: Ficheiro possuí linhas vazias.");
					System.exit(1);
				}

				// in the first iteration it's gonna take data for future validations
				if(first){
					standard_len = line.length();
					lines = new char[standard_len][standard_len];
					first = false;
				}

				// given that the matrix is square, we shall analyze the number of rows that are equivalent to the length of the first line
				if (i < standard_len) {
					// checks if all characters inside each line of the matrix are upper case
					if(line.matches("^[A-Z]*$")){
						// checks if all rows have the same length (otherwise it wont be square)
						if(line.trim().length() != standard_len){
							System.err.println("ERRO: Matriz não quadrada ou possui linhas vazias, encerrando programa..");
							System.exit(1); 
						}
						// split into characters and save in i row of the matrix
						lines[i] = line.toCharArray();
						matrix_line_count++;
					}else{
						System.err.println("ERRO: Apenas letras maiusculas são válidas na matriz");
						System.exit(1);
					}
					

				}else{

					// check if all chars in the word section are upper case (thats not supposed to happen)
					if(line.matches("^[A-Z]*$")){
						System.err.println("ERRO: encerrando programa..");
						System.exit(1);
					} 
					
					wordList = LineToList(line);
					
				}
				
				i++;
			}

			// checks if number of rows == number of cols
			if(matrix_line_count != standard_len){
				System.err.println("ERRO: Matriz não quadradra, encerrando programa");
				System.exit(1);

			}else if(matrix_line_count > 40){
				System.err.println("ERRO: Tamanho max ultrapassado (40x40)");
				System.exit(1);
			}

			// seems OK
			grid = new Grid(lines, standard_len);

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// this method will remove words that are substrings of others (example: FARO and FAROL, it will remove FARO)
		wordList = WordInfo.listChecker(wordList);

	}

	

	public static ArrayList<WordInfo> LineToList(String line){
		// split line into an array of words
		String[] wordsInLine = line.split("[ ,;]");
		for(int j = 0; j < wordsInLine.length; j++){
			// for each word checks if it is alfabetical with only down case or both (never only upper) and with min length of 3 
			if(wordsInLine[j].matches("^[a-zA-Z]*$") && !wordsInLine[j].matches("^[A-Z]*$") && wordsInLine[j].length() >= 3 ){
				WordInfo word = new WordInfo(wordsInLine[j].toUpperCase());
				// to ignore duplicated words
				if(!wordList.contains(word)){
					wordList.add(word);
				}
			}else{
				System.out.printf("Palavra *%s* encontrada, não cumpre requesitos de entrada..\nNão será adicionada à lista.\n",wordsInLine[j]);
			}
		}

		return wordList;
	}
}
