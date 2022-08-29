package com.patternJava.behavioral.command.command_3;


/*

https://www.javacodegeeks.com/2012/11/by-your-command-command-design-pattern.html

img_2 - схема


    Як випливає з назви, це стосується дій і подій у програмі.
    
    Постановка проблеми:
        Уявіть собі сценарій, де у нас є веб-сторінка з кількома меню. Одним із способів написання цього коду є наявність 
        кількох умов if else і виконання дій при кожному натисканні меню.

    
                private void getAction(String action){
                  if(action.equalsIgnoreCase('New')){
                      //Створити новий файл
                  }
                  else if(action.equalsIgnoreCase('Open')){
                      //Відкрити наявний файл
                  }
                  if(action.equalsIgnoreCase('Print')){
                      //Друкувати файл
                  }
                  if(action.equalsIgnoreCase('Exit')){
                      //вийти з програми
                  }
              }
  
  Ми повинні виконати дії на основі рядка дій. Однак наведений вище код має забагато умов if і не читається, якщо він розширюється далі.
  
  Намір:
        Запитувач дії має бути від’єднаний від об’єкта, який виконує цю дію.
        Дозволити інкапсуляцію запиту як об’єкта. Зверніть увагу на цей рядок, оскільки це дуже важлива концепція для шаблону команд.
        Дозволити зберігання запитів у черзі, тобто дозволяє зберігати список дій, які можна виконати пізніше.
  
  рішення:
        Як згадувалося вище, шаблон команди переміщує вищезазначену дію до об’єктів через інкапсуляцію. 
        Ці об’єкти при виконанні виконують команду. Тут кожна команда є об'єктом. Тож нам доведеться створити окремі 
        класи для кожної дії меню, наприклад NewClass , OpenClass , PrintClass , ExitClass . 
        
        І всі ці класи успадковують батьківський інтерфейс, який є командним інтерфейсом. 
        Цей інтерфейс (Command interface) абстрагує/обгортає всі дочірні класи дій.
        
        
  Тепер ми представляємо клас Invoker, 
    основна робота якого полягає в тому, щоб зіставляти дію з класами, які мають цю дію. 
    По суті, він утримує дію та отримує команду для виконання запиту шляхом виклику методу execute().
    
    Ще один важливий клас Receiver. 
        Клас одержувача знає про те, що робити, щоб виконати операцію.
    
      
    Кроки (6 кроків):

    1. Визначте командний інтерфейс із сигнатурою методу, наприклад execute(). 
        У наведеному прикладі ActionListenerCommand — це командний інтерфейс, який має один метод execute().
        
    2. Створіть один або кілька похідних класів, 
        які інкапсулюють деяку підмножину з наступного: об’єкт «receiver» («одержувач»), метод для виклику, аргументи для передачі. 
        
        У наведеному вище прикладі ActionOpen і ActionSave є конкретними класами команд, 
        які створюють зв’язок між одержувачем і дією (the receiver and the action). 
        Клас ActionOpen викликає метод дії класу receiver-приймача (у цьому випадку клас Document) у execute() . 
        Таким чином указуючи класу приймача, що потрібно зробити.
        
    3. Створіть екземпляр об’єкта Command для кожного запиту на відкладене виконання.
    
    4. Передайте об’єкт Command від творця до того, хто викликає. (Pass the Command object from the creator to the invoker.)
    
    5. invoker вирішує, коли execute(). (The invoker decides when to execute().)
    
    6. Клієнт створює екземпляр об’єкта Receiver (Document) і об’єктів Command і дозволяє виконавцю викликати команду.
    
   
   
    Переваги:
        Command pattern helps to decouple the invoker and the receiver.(Шаблон команди допомагає роз’єднати викликаючого та одержувача.)
         Одержувач - це той, хто знає, як виконати дію.
        Команда повинна мати можливість виконувати операції скасування та повторення.
        Цей шаблон допомагає з точки зору розширюваності, оскільки ми можемо додати нову команду, не змінюючи існуючий код.

    Недолік:
        Головним недоліком шаблону Команда є збільшення кількості класів для кожної окремої команди. 
        Ці елементи також могли бути зроблені за допомогою реалізації методу. Однак класи шаблонів команд легші для читання, 
        ніж створення кількох методів за допомогою умови if else.

    Цікаві моменти:
        Реалізації java.lang.Runnable і javax.swing.Action відповідають шаблону проектування команд.
        Команда може використовувати Memento для підтримки стану, необхідного для операції скасування.
        
 */



// Client class:
public class CommandMain {
    public static void main(String[] args) {
        Document doc = new Document();

        ActionListenerCommand clickOpen = new ActionOpen(doc);
        ActionListenerCommand clickSave = new ActionSave(doc);

        MenuOptions menu = new MenuOptions(clickOpen, clickSave);
        menu.clickOpen();
        menu.clickSave();
    }
}

// Command interface:
interface ActionListenerCommand {
    void execute();
}

// Receiver class:
class Document {
    public void open(){
        System.out.println("Document Opened");
    }
    public void save(){
        System.out.println("Document Saved");
    }
}

// Concrete Command = ActionOpen:
class ActionOpen implements ActionListenerCommand {
    private Document doc;

    public ActionOpen(Document doc) {
        this.doc = doc;
    }
    @Override
    public void execute() {
        doc.open();
    }
}

// Concrete Command = ActionSave:
class ActionSave implements ActionListenerCommand {
    private Document doc;

    public ActionSave(Document doc) {
        this.doc = doc;
    }
    @Override
    public void execute() {
        doc.save();
    }
}

// Invoker class:
class MenuOptions {
    private ActionListenerCommand openCommand;
    private ActionListenerCommand saveCommand;

    public MenuOptions(ActionListenerCommand open, ActionListenerCommand save) {
        this.openCommand = open;
        this.saveCommand = save;
    }
    public void clickOpen(){
        openCommand.execute();
    }
    public void clickSave(){
        saveCommand.execute();
    }
}