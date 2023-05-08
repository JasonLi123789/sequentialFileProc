import java.io.*;

public class SequentialFileStimulation {

    // Declares a constant String variable named FILENAME
    // and initializes it with the path to a file named input.txt
    private static final String FILENAME = "src/input.txt";

    public static void main(String[] args) {
        // Simulate reading from a file
        System.out.println("Reading from file...");
        readFromFile(FILENAME);

        // Simulate writing to a file
        System.out.println("Writing to file...");
        String[] data = {"1","2","3","4","5","6","7","8"};
        writeToFile(FILENAME, data);

        // Simulate reading from the file again to verify the write operation
        System.out.println("Reading from file again...");
        readFromFile(FILENAME);
    }

    private static void readFromFile(String filename) {
        //Declares a variable named reader of type
        // BufferedReader and initializes it to null.
        BufferedReader reader = null;

        try {
            // Creates a new BufferedReader object and initializes it
            // with a FileReader object that is initialized with the filename parameter
            reader = new BufferedReader(new FileReader(filename));
            // Reads the first line of the file
            String line = reader.readLine();
            // Loops through each line of the file and prints it to
            // the console until the end of the file is reached
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Catches any IOException that may occur while reading
            // from the file and prints an error message to the console
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        } finally {
            // Closes the BufferedReader object, if it is not null
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                // Catches any IOException that may occur while
                // closing the file and prints an error message to the console
                System.out.println("An error occurred while closing the file.");
                e.printStackTrace();
            }
        }
    }

    // A method that writes to a file
    private static void writeToFile(String filename, String[] data) {
        BufferedWriter writer = null;
        try {
            // Creates a new BufferedWriter object and initializes it with a
            // FileWriter object that is initialized with the filename parameter and set to append mode
            writer = new BufferedWriter(new FileWriter(filename, true));
            // Loops through each element of the data array and
            // writes it to the file, with a new line character after each element
            for(int i=0; i< data.length; i++){
                writer.write(data[i]);
                writer.newLine();
            }

        } catch (IOException e) {
            // Catches any IOException that may occur while writing to
            // the file and prints an error message to the console
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            // Closes the BufferedWriter object, if it is not null
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                // Catches any IOException that may occur while
                // closing the file and prints an error message to the console
                System.out.println("An error occurred while closing the file.");
                e.printStackTrace();
            }
        }
    }
}
