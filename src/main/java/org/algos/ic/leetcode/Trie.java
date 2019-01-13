package org.algos.ic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("abc");
        trie.insertWord("bca");

        System.out.println(trie.search("abc"));

    }

    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    private class TrieNode{

        Map<Character,TrieNode> children;
        boolean endOfWord;

        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }

    }

    public void insertWord(String word){

        TrieNode curr = root;
        for(int i=0;i<word.length();i++){

            char currentCharacter = word.charAt(i);
            TrieNode node = curr.children.get(currentCharacter);
            if(node==null){
                node = new TrieNode();
                curr.children.put(currentCharacter,node);
            }
            curr = node;
        }
        curr.endOfWord = true;
    }

    public boolean search(String word){

        TrieNode curr = root;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = curr.children.get(c);

            if(node==null) return false;
            curr = node;
        }
        return curr.endOfWord;
    }

    /**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }

}
