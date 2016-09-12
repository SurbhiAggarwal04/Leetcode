package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Trie
{
	int pos=-1;
	Trie[] nodes=new Trie[26];
	ArrayList<Integer> itselfPalinIndexes=new ArrayList<>();
	public void add(int pos,String word)
	{ 
		Trie current=this;
		Trie previous=current;
		for(int i=word.length()-1;i>=0;i--)
		{
			char ch=word.charAt(i);
			if(isPalindrome(word,0,i) && i>0)
			{
					current.itselfPalinIndexes.add(0,pos);
			}
				
			if(current.nodes[ch-'a']==null)
			{
				current.nodes[ch-'a']=new Trie();
			}
			    previous=current;
				current=current.nodes[ch-'a'];
			
		}
		current.pos=pos;
		
		System.out.println("word:"+word+" pos:"+current.pos+" "+itselfPalinIndexes.size()+" "+itselfPalinIndexes);
	}
	public boolean isPalindrome(String word,int start,int end)
	{
		
		for(int i=start,j=end;i<j;i++,j--)
		{
			if(word.charAt(i)!=word.charAt(j))return false;
		}
		return true;
		
	}
	
	public String toString()
	{
		String result="";
		for(int i=0;i<26;i++)
		{
			if(this.nodes[i]!=null)
			{
				char ch=(char) ('a'+i);
				result+=" "+ch+" "+pos;			}
		}
		return result;
	}
	public static void display(Trie current)
	{
		if(current!=null)
			{
			System.out.println(current);
			for(int i=0;i<26;i++)
				display(current.nodes[i]);
			}
		
	}
	public void search(String word,int index,List<List<Integer>> ans)
	{
		Trie current=this;
		int i=0;
		ArrayList<Integer> temp=new ArrayList<>();
		int palinPosition=0;
		System.out.println("word:"+word+" index:"+index);
		for(i=0;i<word.length();i++)
		{
			if(current.nodes[word.charAt(i)-'a']==null)return;
			else
			{
				System.out.println(word.charAt(i)+" "+(word.charAt(i)-'a'));
				current=current.nodes[word.charAt(i)-'a'];
				if(current!=null && current.pos!=-1)
				{
					if(isPalindrome(word, i+1, word.length()-1) && current.pos!=index)
					{
						temp.add(current.pos);
						System.out.println("added:"+current.pos);
					}
					
				}
				
			}
		}
		if(i==word.length())
		{
			System.out.println("inside");
			System.out.println(current.itselfPalinIndexes.size());
			for(int k=0;k<current.itselfPalinIndexes.size();k++)
			{
				System.out.println("added from list:"+current.pos);
				temp.add(current.itselfPalinIndexes.get(k));
			}
		}
		if(i!=0 && i<word.length() && current.pos!=-1)
		{
			if(isPalindrome(word, i, word.length()-1))
			{
				temp.add(current.pos);
				System.out.println("added:"+current.pos);
			}
		}
		ans.add(index, temp);
		System.out.println("partial "+ans);
	}
}
public class PalindromePairs {

public static void main(String[] args) {
	String words[] = {"abcd", "dcba", "lls", "s", "sssll"};
	List<List<Integer>> result=new ArrayList<>();
	Trie root=new Trie();
	for(int i=0;i<words.length;i++)
	{
		root.add(i, words[i]);
	}
	Trie.display(root);
	for(int i=0;i<words.length;i++)
	{
		
		root.search(words[i],i,result);
	}
	System.out.println(result);

}
}
