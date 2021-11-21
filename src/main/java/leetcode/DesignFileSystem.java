package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class DesignFileSystem {
    public static void main(String[] args) {
        String st = "/";
        System.out.println(Arrays.toString(st.split("/")));
    }

    static class Node{
        String name;
        Map<String, StringBuilder> files;
        Map<String, Node> dirs;

        Node(String name){
            this.name=name;
            files = new HashMap<>();
            dirs = new HashMap<>();
        }

        Node addDirectory(String name){
            Node dir = new Node(name);
            dirs.put(name, dir);
            return dir;
        }

        StringBuilder addFile(String name){
            files.put(name, new StringBuilder());
            return files.get(name);
        }

        List<String> getNames(){
            List<String> list = new ArrayList<>(dirs.keySet());
            list.addAll(files.keySet());
            Collections.sort(list);
            return list;
        }

        boolean containsDir(String name){
            return dirs.containsKey(name);
        }

        boolean containsFile(String name){
            return files.containsKey(name);
        }

        Node getDir(String name){
            return dirs.get(name);
        }

        StringBuilder getFile(String name){
            return files.get(name);
        }
    }
    Node root;
    public DesignFileSystem() {
        root = new Node("");
    }

    public List<String> ls(String path) {
        String[] words = path.split("/");
        if(words.length==1) return root.getNames();
        Node ptr = root;
        int i=1;
        while(i < words.length-1){
            ptr=ptr.getDir(words[i++]);
        }
        if(ptr.containsDir(words[i])){
            return ptr.getDir(words[i]).getNames();
        }
        return Arrays.asList(words[i]);
    }

    public void mkdir(String path) {
        String[] words = path.split("/");
        Node ptr = root;
        int i=1;
        while(i < words.length){
            if(ptr.containsDir(words[i])){
                ptr=ptr.getDir(words[i]);
            }else{
                ptr=ptr.addDirectory(words[i]);
            }
            i++;
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] words = filePath.split("/");
        Node ptr = root;
        int i=1;
        while(i < words.length-1){
            if(ptr.containsDir(words[i])){
                ptr=ptr.getDir(words[i]);
            }else{
                ptr=ptr.addDirectory(words[i]);
            }
            i++;
        }
        if(ptr.containsFile(words[i])){
            ptr.getFile(words[i]).append(content);
        }else{
            ptr.addFile(words[i]).append(content);
        }

    }

    public String readContentFromFile(String filePath) {
        String[] words = filePath.split("/");
        Node ptr = root;
        int i=1;
        while(i < words.length-1){
            if(ptr.containsDir(words[i])){
                ptr=ptr.getDir(words[i]);
            }else{
                ptr=ptr.addDirectory(words[i]);
            }
            i++;
        }
        return ptr.getFile(words[i]).toString();
    }
}
