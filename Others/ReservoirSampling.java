public void reservoirSampling () throws FileNotFoundException, IOException
	 {
	 File f = new File("data.txt");
	 BufferedReader br = new BufferedReader(new FileReader(f));   // creating buffered reader object to read the file contains our data
	 String currentLine;
	 int reservoirSize=10;
	 List <String> reservoirList= new ArrayList<String>(reservoirSize);   //reservoirList is where our selected lines stored
	 int count=0;                           // we will use this counter to count the current line numebr while iterating
	 Random ra = new Random();
	 
	int randomNumber;
	 while ((currentLine = br.readLine()) != null)                             // here we will iterate through the file till it ends
	 {
	 count ++;                                         // increase the line number
	 if (count<=10)
	 {
	 reservoirList.add(currentLine);
	 }
	 else
	 {
	randomNumber = (int)ra.nextInt(count);
	 if (randomNumber<reservoirSize)
	 {
	 reservoirList.set(randomNumber, currentLine);
	 }
	 }
	 }
	 }