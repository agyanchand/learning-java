package avi.learning.structures;

public class Trie {
	TrieNode rootNode;
	
	public Trie() {
		rootNode = new TrieNode();
	}
	
	public void insertWord(String word) {
		if(word != null) {
			rootNode.insert(word.toLowerCase());
		}
	}
	
	public boolean hasWord(String word) {
		boolean valid = false;
		if(word != null) {
			valid = rootNode.has(word.toLowerCase());
		}
		return valid;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insertWord("Hello");
		trie.insertWord("Hell");
		trie.insertWord("HelloFood");
		System.out.println(trie.hasWord("hell"));
	}


	class TrieNode {
		private TrieNode[] charSets;
		private boolean isLeaf = false;
		
		public TrieNode() {
			charSets = new TrieNode[26];
		}
		
		public void insert(String word) {
			int charIndex = word.charAt(0) - 'a';
			
			if(charSets[charIndex] == null) {
				charSets[charIndex] = new TrieNode();
			}
			
			if(word.length() > 1) {
				charSets[charIndex].insert(word.substring(1));
			} else {
				isLeaf = true;
			}
		}
		
		public boolean has(String word) {
			int charIndex = word.charAt(0) - 'a';
			
			if(charSets[charIndex] == null) {
				return false;
			}
			
			if(word.length() > 1) {
				return charSets[charIndex].has(word.substring(1));
			} else {
				return isLeaf;
			}
		}
	}
}
