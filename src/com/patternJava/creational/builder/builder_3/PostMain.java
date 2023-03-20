package com.patternJava.creational.builder.builder_3;

public class PostMain {
    public static void main(String[] args) {
        Post post = new Post.Builder("blog-post", "javadev")
                .datePosted("20/03")
                .numberOfWords(1000)
                .numberOfCharacters(5000)
                .build();

        System.out.println("post = " + post); 
        // post = Post{title='blog-post', author='javadev', datePosed='20/03', numberOfWords=1000, numberOfCharacters=5000}

        
        
        Post post2 = new Post.Builder("blog-post-2", "javadev")
                .build();

        System.out.println("post2 = " + post2);
        // post2 = Post{title='blog-post-2', author='javadev', datePosed='null', numberOfWords=0, numberOfCharacters=0}


        Post.Builder postBuilder = new Post.Builder("blog-post-builder", "javadev");
        postBuilder.datePosted("20/03")
                .numberOfWords(100)
                .numberOfCharacters(500)
                .build();

        System.out.println("postBuilder = " + postBuilder);
        // postBuilder = Builder{title='blog-post-builder', author='javadev', datePosed='20/03', numberOfWords=100, numberOfCharacters=500}
        
        Post newPost = postBuilder.numberOfCharacters(1000)
                .build();

        System.out.println("newPost = " + newPost);
        // newPost = Post{title='blog-post-builder', author='javadev', datePosed='20/03', numberOfWords=100, numberOfCharacters=1000}
    }
}
