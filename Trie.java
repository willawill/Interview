import java.lang.String;

public class Trie
{

    private static final int ALPH = 26;
    private static final int BUFSIZ = 1024;
    private Trie[]  myLinks;
    private boolean myIsWord;
    public int count;


    public Trie()
    {
	myLinks = new Trie[ALPH];
	myIsWord = false;
	count = 0;
    }

    public void addString(String s)
    {
	Trie t = this;
	int k;
	int limit = s.length();
	for(k=0; k < limit; k++)
	{
	    int index = s.charAt(k) - 'a';
	    if (t.myLinks[index] == null)
	    {
		t.myLinks[index] = new Trie();
		t.count = t.count + 1;
	    }
	    
	    System.out.println(t.count);
	    t = t.myLinks[index];
	}
	t.myIsWord = true;
    }

    public void addCString(char s[])
    {
	Trie t = this;
	int k=0;
	while (s[k] != '\0')
	{
	    int index = s[k] - 'a';
	    if (t.myLinks[index] == null)
	    {
		t.myLinks[index] = new Trie();
	    }
	    t = t.myLinks[index];
	    k++;
	}
	t.myIsWord = true;
    }

    /**
     * print every word in the trie, one per line
     *
     */
    
    public void Print()
    {
	//DoPrint("",this);
	apply(new Recorder());
    }

    public void apply(Recorder rec)
    {
	char[] buffer = new char[BUFSIZ];	 
	doApply(rec,0,buffer,this);
    }

    private void doApply(Recorder rec, int index, char buffer[], Trie t)
    {
	if (t != null)
	{
	    if (t.myIsWord)
	    {
			rec.record(new String(buffer,0,index) + t.count);
	    }
	    int k;
	    for(k=0; k < ALPH; k++)
	    {
		if (t.myLinks[k] != null)
		{
		    buffer[index] = (char)(k+'a');
		    doApply(rec,index+1,buffer,t.myLinks[k]);
		}
	    }
	}	    
    }

      
    public boolean isWord(String s)
    {
	Trie t = this;
	int k;
	int limit = s.length();
	for(k=0; k < limit; k++)
	{
	    int index = s.charAt(k) - 'a';
	    if (t.myLinks[index] == null) return false;
	    	t = t.myLinks[index];
	}
	return t.myIsWord;
    }

    /**
     * @return true iff path from some root to this node is a word
     * 
     */
    
    public boolean isWord()
    {
	return myIsWord;
    }

    /**
     * @param ch Character used to index node (find child)
     * @return Trie formed from this by indexing using ch
     */
    
    Trie childAt(char ch)
    {
	return myLinks[ch-'a'];
    }


    public static void main(String[] args){
    	Trie myTrie = new Trie();
    	myTrie.addString("int");
    	// myTrie.addString("ant");
    	// myTrie.addString("att");
    	// myTrie.addString("bat");
    	// myTrie.addString("limit");
    	// System.out.println(myTrie.isWord("ban"));
    	myTrie.Print();	
    }
}

class Recorder 
{
    public void record(Object o)
    {
	System.out.println(o);
    }

    public void report()
    {
	// nothing to do here
    }
}