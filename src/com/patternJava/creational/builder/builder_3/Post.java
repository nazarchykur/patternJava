package com.patternJava.creational.builder.builder_3;

public class Post {
    private String title;
    private String author;
    private String datePosed;
    private int numberOfWords;
    private int numberOfCharacters;
    private Post(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.datePosed = builder.datePosed;
        this.numberOfWords = builder.numberOfWords;
        this.numberOfCharacters = builder.numberOfCharacters;
    }
    public static class Builder {
        private String title;
        private String author;
        private String datePosed = null;
        private int numberOfWords = 0;
        private int numberOfCharacters = 0;
        public Builder(String title, String author) {
            this.title = title;
            this.author = author;
        }
        public Builder datePosted(String datePosed) {
            this.datePosed = datePosed;
            return this;
        }
        public Builder numberOfWords(int numberOfWords) {
            this.numberOfWords = numberOfWords;
            return this;
        }
        public Builder numberOfCharacters(int numberOfCharacters) {
            this.numberOfCharacters = numberOfCharacters;
            return this;
        }
        public Post build() {
            return new Post(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", datePosed='" + datePosed + '\'' +
                    ", numberOfWords=" + numberOfWords +
                    ", numberOfCharacters=" + numberOfCharacters +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", datePosed='" + datePosed + '\'' +
                ", numberOfWords=" + numberOfWords +
                ", numberOfCharacters=" + numberOfCharacters +
                '}';
    }
}

/*
Builder Будівельник

    Обговорений тут підхід Builder є формою шаблону Gang of four Builder. 
    
    Спочатку ми створюємо об’єкт Builder, передаючи обов’язкові поля його конструктору. По-друге, ми встановлюємо значення 
    для необов’язкових полів за допомогою сеттер-подібних методів у класі Builder. Нарешті, коли ми передаємо/встановимо 
    всі поля, ми викликаємо  метод buil()  у конструкторі. Цей метод створює об’єкт і повертає його. 

    Builder — це статичний вкладений клас класу Post. 
    1. Ми оголошуємо той самий набір полів, що є в класі Post. 
    2. Конструктор Builder заповнює лише обов’язкові поля. 
    3. Ми визначили один метод для встановлення кожного з необов’язкових полів. Зауважте, що вони повертають сам екземпляр Builder. 
        Це корисно для ланцюжка викликів методів Builder. 
    4. Нарешті, метод build будує та повертає об’єкт Post.
    
    
        Post post = new Post.Builder("blog-post", "javadev")   <= обов’язкові поля
            .datePosted("20/03")                               <= ланцюжок викликів методів Builder, де 
            .numberOfWords(1000)                                  заповнюємо тільки необхідні поля
            .numberOfCharacters(5000)                             тобто якісь поля для когось об'єкта можуть бути опущені
            .build();                                          <= метод build будує та повертає об’єкт Post.
    
    
        System.out.println("post = " + post); 
        // post = Post{title='blog-post', author='javadev', datePosed='20/03', numberOfWords=1000, numberOfCharacters=5000}
        
        
        
        Post post2 = new Post.Builder("blog-post-2", "javadev")
        .build();

        System.out.println("post2 = " + post2);
        // post2 = Post{title='blog-post-2', author='javadev', datePosed='null', numberOfWords=0, numberOfCharacters=0}
    
    
   Скажімо, ми хочемо створити об’єкт публікації, який має ті самі значення для всіх полів, що й вище, за винятком того, 
   що кількість символів становить 6000. Ми не хочемо встановлювати всі поля знову, як пояснювалося раніше. Ми можемо 
   просто повторно використати postBuilder
        
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
        
        
        
    Шаблон конструктора Effective Java долає проблеми двох раніше обговорених підходів (телескопічний конструктор і Javabeans). 
    Це призводить до читабельного коду, оскільки методи конструктора мають назву. Ми створюємо остаточний об’єкт лише тоді, 
    коли викликаємо  метод build()  , і тому ми ніколи не маємо об’єкт у частково сконструйованому стані.
    Недоліком конструктора є те, що він багатослівний, оскільки нам доводиться писати багато коду.            
 */