package com.patternJava.behavioral.visitor.visitor_1;
/*
1) отже є у нас складна структура Project, яка складається з елементів ProjectElement:
ProjectElement - це інтерфейс, який має 3 реалізації:
 - ProjectClass
 - Database
 - Test
 
 beWritten(Developer dev) - метод у ProjectElement, який для кожного елементу цієї структури працює по різному
    в залежності який developer переданий = а щоб знати з яким типом елементу ми працюємо, цей метод передає свій тип елементу 
    
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
    
2)  інтерфейс Developer має методи, кожен з яких окремо працює з кожним типом елементом структури
    void create(ProjectClass projectClass);
    void create(Database database);
    void create(Test test);    
    
    ми маємо 2 реалізації Developer : 
     - JuniorDeveloper
     - SeniorDeveloper
     
3) передаючи конкретного девелопера ми знаємо, що кожен працює з кожним типом елементу структури по свому, 
   що дозволяє виконувати відповідні дії      
 */
public class VisitorMain {
    public static void main(String[] args) {
        Project project = new Project();

        Developer junior = new JuniorDeveloper();
        Developer senior = new SeniorDeveloper();

        System.out.println("=========== junior write code ... ===========");
        
        project.beWritten(junior);
        /*
            Junior write poor code...
            Junior create tables...
            Junior write tests...
         */
        
        System.out.println("=========== senior write code ... ===========");
        project.beWritten(senior);
        /*
            Senior check code after junior...
            Senior correct tables...
            Senior rewrite tests...

         */
    }
}
