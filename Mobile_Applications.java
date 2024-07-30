import java.util.Scanner;

public class Mobile_Applications {
    public static void main(String[] args) {

        while (true) {
            System.out.println("1------Calendar");
            System.out.println("2------PhoneBook");
            System.out.println("3------MusicPlaylist");
            System.out.println("4------Exit");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Choice : ");
            int app_choice = 0;
            app_choice = sc.nextInt();
            sc.nextLine();
            switch (app_choice) {
                case 1: // Case for Application 'Calendar'.
                    Calendar calendar = new Mobile_Applications().new Calendar(); // make an object of inner class
                                                                                  // 'Calendar'
                    Scanner scanner = new Scanner(System.in);

                    boolean exit = false;
                    while (!exit) {
                        System.out.println("\nMenu:");
                        System.out.println("1. Display Calendar");
                        System.out.println("2. Next Month");
                        System.out.println("3. Previous Month");
                        System.out.println("4. Add Event");
                        System.out.println("5. Display Events for Current Month");
                        System.out.println("6. Exit");

                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        switch (choice) {
                            case 1: // Case for 'Display Calendar'
                                calendar.displayCalendar();
                                break;
                            case 2: // Case for 'Move to next Month'
                                calendar.nextMonth();
                                break;
                            case 3: // Case for 'Move to Previous Month'
                                calendar.previousMonth();
                                break;
                            case 4: // Case for 'Adding Event'
                                System.out.print("Enter event title: ");
                                String title = scanner.nextLine();
                                System.out.print("Enter event description: ");
                                String description = scanner.nextLine();
                                System.out.print("Enter day of the month: ");
                                int day = scanner.nextInt();
                                calendar.addEvent(title, description, day);
                                break;
                            case 5: // Case for 'displaying Event'
                                calendar.displayEventsForCurrentMonth();
                                break;
                            case 6: // Case for exiting 'Inner Case'
                                exit = true;
                                break;
                            default: // Default Case.
                                System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    }
                    break;
                case 2: // Case for Application 'PhoneBook'
                    PhoneBook phoneBook = new Mobile_Applications().new PhoneBook(); // Object for inner class
                                                                                     // 'PhoneBook'
                    Scanner scanner1 = new Scanner(System.in);
                    boolean exit2 = false;
                    while (!exit2) {
                        System.out.println("\nMenu:");
                        System.out.println("1. Add Contact");
                        System.out.println("2. Display Contacts by Prefix");
                        System.out.println("3. Display All Contacts");
                        System.out.println("4. Search Contact by Full Name");
                        System.out.println("5. Update Contact");
                        System.out.println("6. Delete Contact");
                        System.out.println("7. Exit");

                        int choice = scanner1.nextInt();
                        scanner1.nextLine(); // Consume newline
                        switch (choice) {
                            case 1: // Case for 'Add Contact'
                                System.out.print("Enter contact name: ");
                                String name = scanner1.nextLine();
                                System.out.print("Enter contact phone number: ");
                                String phoneNumber;
                                int ph_flag = 0;
                                while (true) {
                                    phoneNumber = sc.nextLine();
                                    for (int i = 0; i < phoneNumber.length(); i++) {
                                        if (phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9') {
                                            if (phoneNumber.length() == 10) {
                                                if (phoneNumber.charAt(0) == '9' || phoneNumber.charAt(0) == '8'
                                                        || phoneNumber.charAt(0) == '7'
                                                        || phoneNumber.charAt(0) == '6') {
                                                    ph_flag = 1;
                                                    break;
                                                } else {
                                                    ph_flag = 0;
                                                }
                                            } else {
                                                ph_flag = 0;
                                            }
                                        }
                                    }
                                    if (ph_flag == 1) {
                                        break;
                                    } else if (ph_flag == 0) {
                                        System.out.print("Enter valid number ");
                                        System.out.println(
                                                "Instructions : The number should start from 9,8,7 or 6\nThe number must have atleast 10 digits");
                                    }
                                }
                                phoneBook.addContact(name, phoneNumber);
                                break;
                            case 2: // Case for 'Display Contact By Prefix'
                                System.out.print("Enter prefix to display contacts: ");
                                String prefix = scanner1.nextLine();
                                phoneBook.displayContacts(prefix);
                                break;
                            case 7: // Case for Exiting inner case
                                exit2 = true;
                                break;
                            case 4: // Case for 'Search By FullName'
                                System.out.print("Enter full name to search: ");
                                String searchName = scanner1.nextLine();
                                phoneBook.searchContact(searchName);
                                break;
                            case 5: // Case for 'Update Contact'
                                System.out.print("Enter full name to update: ");
                                String updateName = scanner1.nextLine();
                                System.out.print("Enter new phone number: ");
                                String newPhoneNumber;
                                int ph_flag1 = 0;
                                while (true) {
                                    newPhoneNumber = sc.nextLine();
                                    for (int i = 0; i < newPhoneNumber.length(); i++) {
                                        if (newPhoneNumber.charAt(i) >= '0' && newPhoneNumber.charAt(i) <= '9') {
                                            if (newPhoneNumber.length() == 10) {
                                                if (newPhoneNumber.charAt(0) == '9' || newPhoneNumber.charAt(0) == '8'
                                                        || newPhoneNumber.charAt(0) == '7'
                                                        || newPhoneNumber.charAt(0) == '6') {
                                                    ph_flag1 = 1;
                                                    break;
                                                } else {
                                                    ph_flag1 = 0;
                                                }
                                            } else {
                                                ph_flag1 = 0;
                                            }
                                        }
                                    }
                                    if (ph_flag1 == 1) {
                                        break;
                                    } else if (ph_flag1 == 0) {
                                        System.out.print("Enter valid number ");
                                        System.out.println(
                                                "Instructions : The number should start from 9,8,7 or 6\nThe number must have atleast 10 digits");
                                    }
                                }
                                phoneBook.updateContact(updateName, newPhoneNumber);
                                break;
                            case 6: // Case for 'Delete Contact'
                                System.out.print("Enter full name to delete: ");
                                String deleteName = scanner1.nextLine();
                                phoneBook.deleteContact(deleteName);
                                break;
                            case 3: // Case for 'Display All Contacts'
                                phoneBook.displayAllContacts();
                                break;
                            default: // Default switch
                                System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    }
                    break;
                case 3: // Case for Mobile Application 'MusicPlaylist'
                    Playlist playlist = new Mobile_Applications().new Playlist();
                    Scanner scanner2 = new Scanner(System.in);

                    boolean exit3 = false;
                    while (!exit3) {
                        System.out.println("\nMenu:");
                        System.out.println("1. Add Song");
                        System.out.println("2. Remove Song");
                        System.out.println("3. Shuffle Playlist");
                        System.out.println("4. Display Playlist");
                        System.out.println("5. Display Song Details by Title");
                        System.out.println("6. Display Songs by Artist");
                        System.out.println("7. Get Song Count");
                        System.out.println("8. Clear Playlist");
                        System.out.println("9. Exit");

                        int choice = scanner2.nextInt();
                        scanner2.nextLine(); // Consume newline
                        switch (choice) {
                            case 1: // Case for 'Add Song'
                                System.out.print("Enter song title: ");
                                String title = scanner2.nextLine();
                                System.out.print("Enter artist: ");
                                String artist = scanner2.nextLine();
                                playlist.addSong(new Mobile_Applications().new Song(title, artist));
                                break;
                            case 2: // Case for 'Remove Song'
                                System.out.print("Enter song title to remove: ");
                                String titleToRemove = scanner2.nextLine();
                                playlist.removeSong(titleToRemove);
                                break;
                            case 3: // Case for 'Shuffle PlayList'
                                playlist.shufflePlaylist();
                                System.out.println("Playlist shuffled.");
                                break;
                            case 4: // Case for 'Display Playlist'
                                playlist.displayPlaylist();
                                break;
                            case 5: // Case for 'Display Song Details'
                                System.out.print("Enter song title: ");
                                String titleToDisplay = scanner2.nextLine();
                                playlist.displaySongDetails(titleToDisplay);
                                break;
                            case 6: // Case for 'Display Song By Artist'
                                System.out.print("Enter artist: ");
                                String artistToDisplay = scanner2.nextLine();
                                playlist.displaySongsByArtist(artistToDisplay);
                                break;
                            case 7: // Case for 'Get Song Count'
                                System.out.println("Total songs in the playlist: " + playlist.getSongCount());
                                break;
                            case 8: // Case for 'Clear Playlist'
                                playlist.clearPlaylist();
                                System.out.println("Playlist cleared.");
                                break;
                            case 9: // Case for Exiting inner Switch
                                exit3 = true;
                                break;
                            default: // Default Case
                                System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    }
                    break;
                case 4: // Case for Exiting Outer Switch
                    System.out.println("Thank You!!");
                    System.exit(0);
                    break;
                default: // Default Case
                    System.out.println("Enter Valid Choice!!!");
                    break;
            }
        }

    }

    // 1 - Calendar Code Begins.
    class EventNode { // EventNode Class for LL.
        CalendarEvent event;
        EventNode next;

        public EventNode(CalendarEvent event) {
            this.event = event;
            this.next = null;
        }
    }

    class EventList { // EventList Class that uses LL 'EventNode' for Operations
        EventNode head;

        public EventList() {
            head = null;
        }

        public void insert(CalendarEvent event) { // Insert at Last Method for Insert Data of 'CalendarEvent' Type.
            EventNode newNode = new EventNode(event);
            if (head == null) {
                head = newNode;
            } else {
                EventNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public EventNode getHead() { // Method to get Head
            return head;
        }
    }

    class CalendarEvent { // Class CalendarEvent to add and fetch Data of Calendar.
        String title;
        String description;
        int day;

        public CalendarEvent(String title, String description, int day) {
            this.title = title;
            this.description = description;
            this.day = day;
        }

        @Override
        public String toString() {
            return "Day " + day + ": " + title + " - " + description;
        }
    }

    class Calendar { // Calendar Class
        private int currentYear;
        private int currentMonth;
        private EventList[] events; // Creating array of 'EventList' Class Type where LL has been stored.

        public Calendar() {
            currentYear = 2023;
            currentMonth = 9;
            events = new EventList[31]; // Assuming maximum 31 days in a month
            for (int i = 0; i < events.length; i++) {
                events[i] = new EventList(); // Creating Array Of Objects(Object of LinkedList Type)
            }
        }

        public void addEvent(String title, String description, int day) { // Creating Method 'addEvent'
            if (day >= 1 && day <= events.length) {
                events[currentMonth - 1].insert(new CalendarEvent(title, description, day)); // Insert Event on a
                                                                                             // particular Day.
                System.out.println("Event added on Day " + day);
            } else {
                System.out.println("Invalid day.");
            }
        }

        public void displayCalendar() { // Creating Method 'displayCalendar'
            System.out.println("Calendar for " + currentMonth + "/" + currentYear);
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");

            int totalDays = daysInMonth(currentMonth, currentYear);
            int startDay = dayOfWeek(currentMonth, 1, currentYear);

            int dayCounter = 1;
            for (int i = 0; i < startDay; i++) { // To Fill 'Space' at starting days where no date has been assigned
                System.out.print("    ");
            }

            for (int i = startDay; i < 7; i++) { // To Fill dates in other sections.
                System.out.printf("%3d ", dayCounter);
                dayCounter++;
            }
            System.out.println();

            while (dayCounter <= totalDays) { // To Fill Dates in Last Week.
                for (int i = 0; i < 7 && dayCounter <= totalDays; i++) {
                    System.out.printf("%3d ", dayCounter);
                    dayCounter++;
                }
                System.out.println();
            }
        }

        public void nextMonth() { // Method to Move to Next Month
            currentMonth++;
            if (currentMonth > 12) {
                currentMonth = 1;
                currentYear++;
            }
        }

        public void previousMonth() { // Method to Move to Previous Month
            currentMonth--;
            if (currentMonth < 1) {
                currentMonth = 12;
                currentYear--;
            }
        }

        public void displayEventsForCurrentMonth() { // Method to display event for current month.
            System.out.println("Events for " + currentMonth + "/" + currentYear + ":");
            EventList currentMonthEvents = events[currentMonth - 1];
            EventNode currentEventNode = currentMonthEvents.getHead(); // Getting head of the LL in a temp Variable.

            if (currentEventNode == null) { // if head == null then no events are present.
                System.out.println("No events for this month.");
                return;
            }

            while (currentEventNode != null) { // To Display Events if Present.
                System.out.println(currentEventNode.event);
                currentEventNode = currentEventNode.next;
            }
        }

        private int daysInMonth(int month, int year) { // To set Maximum Days in a Month
            int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            if (month == 2 && isLeapYear(year)) {
                return 29;
            }
            return daysInMonth[month];
        }

        private boolean isLeapYear(int year) { // To Check Leap Year
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        private int dayOfWeek(int month, int day, int year) { // To Calculate Day Of Week.
            if (month < 3) {
                month += 12;
                year--;
            } // In Zeller's Congruence Jan And Feb are considered as the 13th and 14th month
              // of Previous Year.
            int k = year % 100; // to calculate last 2 digit of year.
            int j = year / 100; // to calculate first 2 digit of year.
            int h = (day + 13 * (month + 1)) / 5 + k + k / 4 + j / 4 + 5 * j;
            return h % 7;
        }

    }

    // PhoneBook Code Begins
    class Contact { // Class Contact to add and fetch data.
        String name;
        String phoneNumber;

        public Contact(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Phone: " + phoneNumber;
        }
    }

    class ContactNode { // Class 'ContactNode' to Create LL.
        Contact contact;
        ContactNode next;

        public ContactNode(Contact contact) {
            this.contact = contact;
            this.next = null;
        }
    }

    class ContactList { // Class 'ContactList' with the Implementation Of LL of 'ContacNode'
        ContactNode head;

        public ContactList() {
            head = null;
        }

        public void insert(Contact contact) { // Insert Last Method of LL with data of 'Contact' Type.
            ContactNode newNode = new ContactNode(contact);
            if (head == null) {
                head = newNode;
            } else {
                ContactNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public ContactNode getHead() { // Method to 'Get Head'
            return head;
        }
    }

    class PhoneBook { // Class PhoneBook
        private ContactList[] contacts; // Array Declaration of type 'ContactList' which contains LL in it.

        public PhoneBook() {
            contacts = new ContactList[26]; // One list for each letter of the alphabet
            for (int i = 0; i < contacts.length; i++) {
                contacts[i] = new ContactList(); // Creating Array of Object(Object of ContactList)
            }
        }

        private int getIndex(String name) { // method to 'GetIndex'
            char firstLetter = name.charAt(0);
            return Character.toLowerCase(firstLetter) - 'a'; // logic to set index acc to Array. i.e if first letter of
                                                             // ame is a then it will return index '0'.
        }

        public void addContact(String name, String phoneNumber) { // method to 'add Contact'
            Contact contact = new Contact(name, phoneNumber);
            int index = getIndex(name);
            contacts[index].insert(contact);
            System.out.println("Contact added: " + contact);
        }

        public void searchContact(String fullName) { // Method to 'Search Contact'
            int index = getIndex(fullName);
            ContactNode current = contacts[index].getHead(); // Setting a head in temperory variable called 'current'.
            System.out.println("Contacts with full name '" + fullName + "':");
            while (current != null) {
                if (current.contact.name.equalsIgnoreCase(fullName)) {
                    System.out.println(current.contact);
                    return; // Exit after finding the first matching contact
                }
                current = current.next;
            }
            System.out.println("Contact not found.");
        }

        public void displayContacts(String prefix) { // Method to 'Display Contacts'
            System.out.println("Contacts with prefix '" + prefix + "':");
            for (int i = 0; i < contacts.length; i++) {
                ContactNode current = contacts[i].getHead(); // Setting a head in temperory variable called 'current'.
                while (current != null) {
                    if (current.contact.name.toLowerCase().startsWith(prefix.toLowerCase())) {
                        System.out.println(current.contact);
                    }
                    current = current.next;
                }
            }
        }

        public void updateContact(String fullName, String newPhoneNumber) { // Method to 'update Contact'
            int index = getIndex(fullName);
            ContactNode current = contacts[index].getHead(); // Setting a head in temperory variable called 'current'.
            while (current != null) {
                if (current.contact.name.equalsIgnoreCase(fullName)) {
                    current.contact.phoneNumber = newPhoneNumber;
                    System.out.println("Contact updated: " + current.contact);
                    return; // Exit after updating the first matching contact
                }
                current = current.next;
            }
            System.out.println("Contact not found.");
        }

        public void deleteContact(String fullName) { // Method to 'delete Contact'
            int index = getIndex(fullName);
            ContactNode current = contacts[index].getHead(); // Setting a head in temperory variable called 'current'.
            ContactNode prev = null; // Usage of another Node to set both front and back Contacts

            while (current != null) {
                if (current.contact.name.equalsIgnoreCase(fullName)) {
                    if (prev == null) {
                        contacts[index].head = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    System.out.println("Contact deleted: " + current.contact);
                    return; // Exit after deleting the first matching contact
                }
                prev = current;
                current = current.next;
            }
            System.out.println("Contact not found.");
        }

        public void displayAllContacts() { // Method to 'Display All Contacts'
            System.out.println("All Contacts:");
            for (int i = 0; i < contacts.length; i++) {
                ContactNode current = contacts[i].getHead(); // Setting a head in temperory variable called 'current'.
                while (current != null) {
                    System.out.println(current.contact);
                    current = current.next;
                }
            }
        }
    }

    // MusicPlayList Code Begins.
    class LinkedListNode<T> { // Class LinkedListNode for LL.
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList<T> { // Class LinkedList for Implementation of LinkedListNode.
        private LinkedListNode<T> head;
        private int size;

        public LinkedList() {
            head = null;
            size = 0;
        }

        public void insert(T data) { // InsertAtLast Method
            LinkedListNode<T> newNode = new LinkedListNode<>(data);
            if (head == null) {
                head = newNode;
            } else {
                LinkedListNode<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        public boolean isEmpty() { // Method 'isEmpty'
            return head == null;
        }

        public int size() { // Method 'Size'
            return size;
        }

        public T removeFirst() { // Method 'DeleteFirst'
            if (!isEmpty()) {
                T data = head.data;
                head = head.next;
                size--;
                return data;
            }
            return null;
        }

        public LinkedListNode<T> getHead() { // Method 'getHead'
            return head;
        }

        public void setHead(LinkedListNode<T> newHead) { // Method 'SetHead'
            head = newHead;
        }
    }

    class Queue1<T> { // Class Queue which implements Queue.
        private LinkedList<T> elements;

        public Queue1() { // Insertion of LL in Queue.
            elements = new LinkedList<>();
        }

        public void enqueue(T element) { // Method to insert
            elements.insert(element);
        }

        public T dequeue() { // Method to delete.
            return elements.removeFirst();
        }

        public boolean isEmpty() { // Method 'isEmpty'
            return elements.isEmpty();
        }

        public int size() { // Method 'size'
            return elements.size();
        }
    }

    class Song { // class Song to add data in LL.
        String title;
        String artist;

        public Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        @Override
        public String toString() {
            return title + " by " + artist;
        }
    }

    class Playlist { // Class Playlist
        private LinkedList<Song> songs;

        public Playlist() {
            songs = new LinkedList<>();
        }

        public void addSong(Song song) { // Method 'Add Song'
            songs.insert(song);
        }

        public void removeSong(String title) { // Method 'Remove Song'
            LinkedListNode<Song> current = songs.getHead(); // Setting a head in temperory variable called 'current'.
            LinkedListNode<Song> previous = null; // Setting another previous Pointer.
            while (current != null) {
                if (current.data.getTitle().equals(title)) {
                    if (previous == null) {
                        songs.setHead(current.next);
                    } else {
                        previous.next = current.next;
                    }
                    break;
                }
                previous = current;
                current = current.next;
            }
        }

        public void shufflePlaylist() { // Method to 'ShuffleThePlaylist'
            Queue1<Song> songQueue = new Queue1<>(); // Declare songQueue
            LinkedListNode<Song> current = songs.getHead(); // Setting a head in temperory variable called 'current'.
            while (current != null) {
                songQueue.enqueue(current.data); // Inserting a data of LL to Queue.
                current = current.next;
            }
            songs.setHead(null);
            while (!songQueue.isEmpty()) {
                int randomIndex = (int) (Math.random() * songQueue.size());
                Song songToInsert = songQueue.dequeue(); // Dequeue the song
                LinkedListNode<Song> newPlaylistNode = new LinkedListNode<>(songToInsert); // Create a new playlist node

                LinkedListNode<Song> currentPlaylistNode = songs.getHead(); // Setting a head in temperory variable
                                                                            // called 'currentPlaylistNode'.
                if (currentPlaylistNode == null) {
                    songs.setHead(newPlaylistNode); // Setting a head to 'new playlist' if 'currentPlaylist' is null.
                } else {
                    while (randomIndex > 0 && currentPlaylistNode.next != null) {
                        currentPlaylistNode = currentPlaylistNode.next;
                        randomIndex--;
                    } // if there are more than one elements then shuffle the playlist
                    newPlaylistNode.next = currentPlaylistNode.next;
                    currentPlaylistNode.next = newPlaylistNode;
                }
            }
        }

        public void displayPlaylist() { // method to 'displayPlaylist'
            System.out.println("Playlist:");
            LinkedListNode<Song> current = songs.getHead(); // Setting a head in temperory variable called 'current'.
            int index = 1;
            while (current != null) {
                System.out.println(index + ". " + current.data);
                current = current.next;
                index++;
            }
        }

        public int getSongCount() { // Method to 'getSongCount'
            return songs.size();
        }

        public void clearPlaylist() { // Method to 'clearPlaylist'
            songs.setHead(null);
        }

        public void displaySongDetails(String title) { // Method to 'displaySongDetails'
            LinkedListNode<Song> current = songs.getHead(); // Setting a head in temperory variable called 'current'.
            while (current != null) {
                if (current.data.getTitle().equalsIgnoreCase(title)) {
                    System.out.println("Song Details:");
                    System.out.println("Title: " + current.data.getTitle());
                    System.out.println("Artist: " + current.data.getArtist());
                    return;
                }
                current = current.next;
            }
            System.out.println("Song not found.");
        }

        public void displaySongsByArtist(String artist) { // Method to 'displaySongsByArtist'
            System.out.println("Songs by " + artist + ":");
            LinkedListNode<Song> current = songs.getHead(); // Setting a head in temperory variable called 'current'.
            int index = 1;
            while (current != null) {
                if (current.data.getArtist().equalsIgnoreCase(artist)) {
                    System.out.println(index + ". " + current.data);
                    index++;
                }
                current = current.next;
            }
        }
    }

}

/*
 * ---------->On Execution of code we get following output
 * 1------Calendar
 * 2------PhoneBook
 * 3------MusicPlaylist
 * 4------Exit
 * Enter Choice :
 * ----------> Enter choice 1 following menu appears
 * 
 * Menu:
 * 1. Display Calendar
 * 2. Next Month
 * 3. Previous Month
 * 4. Add Event
 * 5. Display Events for Current Month
 * 6. Exit
 * 
 * ---------->Enter choice 1 data of current month appears
 * 1
 * Calendar for 9/2023
 * Sun Mon Tue Wed Thu Fri Sat
 * 1 2
 * 3 4 5 6 7 8 9
 * 10 11 12 13 14 15 16
 * 17 18 19 20 21 22 23
 * 24 25 26 27 28 29 30
 * ----------> Again main menu appears as it is in while loop so till Exit is
 * not pressed the code keeps on itrating
 * Menu:
 * 1. Display Calendar
 * 2. Next Month
 * 3. Previous Month
 * 4. Add Event
 * 5. Display Events for Current Month
 * 6. Exit
 * ---------->Enter choice 2 to shift to next month
 * 2
 * ---------->After that do 1 to get calendar of the next month which is for now
 * the currentm month
 * 1
 * Calendar for 10/2023
 * Sun Mon Tue Wed Thu Fri Sat
 * 1 2 3 4 5 6 7
 * 8 9 10 11 12 13 14
 * 15 16 17 18 19 20 21
 * 22 23 24 25 26 27 28
 * 29 30 31
 * ---------->Enter choice 3 to go back to previous month once again Enter 3 to
 * go previous again
 * 3
 * 3
 * ---------->Enter choice 1 to display calendar of previous month for current
 * month
 * 1
 * Calendar for 8/2023
 * Sun Mon Tue Wed Thu Fri Sat
 * 1 2 3 4 5
 * 6 7 8 9 10 11 12
 * 13 14 15 16 17 18 19
 * 20 21 22 23 24 25 26
 * 27 28 29 30 31
 * ---------->Enter choice 4 to add event in that month so for that we will come
 * back in current month which is 9
 * ---------->by chossing 2
 * 2
 * 4
 * ---------->It ask for details about events and date
 * Enter event title:
 * 
 * ---------->Enter data
 * birthday
 * Enter event description:
 * My birthday
 * Enter day of the month:
 * ---------->Enter data
 * 5
 * Event added on Day 5
 * ---------->Enter choice 5 to get events on that particular month
 * 5
 * Events for 9/2023:
 * Day 5: birthday - My birthday
 * ---------->Enter choice 6 to Exit the Calendar
 * 6
 * ---------->Main Menu appears
 * ---------->Enter choice 2 to go to Phonbook
 * Enter Choice :
 * 2
 * ---------->You enter in PhoneBook
 * Menu:
 * 1. Add Contact
 * 2. Display Contacts by Prefix
 * 3. Display All Contacts
 * 4. Search Contact by Full Name
 * 5. Update Contact
 * 6. Delete Contact
 * 7. Exit
 * ---------->Enter 1 to add contacts
 * 1
 * Enter contact name:
 * ---------->Enter Name
 * Yashvi
 * Enter contact phone number:
 * ---------->Enter Number
 * 9087654321
 * Contact added: Name: Yashvi, Phone: 9087654321
 * ---------->Add 1 more number
 * 1
 * Enter contact name: Kavish
 * Enter contact phone number: 9080908234
 * Contact added: Name: Kavish , Phone: 9080908234
 * ---------->Enter choice 2 to get Contacts starting from 'Y'
 * 2
 * Enter prefix to display contacts: Y
 * Contacts with prefix 'Y':
 * Name: Yashvi, Phone: 9087654321
 * ---------->Again main menu appears
 * Menu:
 * 1. Add Contact
 * 2. Display Contacts by Prefix
 * 3. Display All Contacts
 * 4. Search Contact by Full Name
 * 5. Update Contact
 * 6. Delete Contact
 * 7. Exit
 * ---------->Enter choice 3 to get all the contacts
 * 3
 * All Contacts:
 * Name: Kavish , Phone: 9080908234
 * Name: Yashvi, Phone: 9087654321
 * ---------->Contacts are displayed in alphabetical order
 * ---------->Enter choice 4 to search by full name 'Kavish'
 * 4
 * Enter full name to search:
 * Kavish
 * Contacts with full name 'Kavish':
 * Name: Kavish, Phone: 9080908234
 * ---------->Enter choice 5 to update number of particular contact
 * 5
 * ---------->If user inputs not reliable data it pops message not found
 * Enter full name to update: Yash
 * Enter new phone number: 123
 * Contact not found.
 * ---------->Try again
 * Enter full name to update:
 * Yashvi
 * Enter new phone number: 999999999
 * Contact updated: Name: Yashvi, Phone:
 * ---------->Enter choice 3 to see the updated contact
 * 3
 * All Contacts:
 * Name: Kavish, Phone: 9080908234
 * Name: Yashvi, Phone: 9999999999
 * ---------->Enter choice 6 to delete a particular contact
 * 6
 * Enter full name to delete:
 * Yashvi
 * Contact deleted: Name: Yashvi, Phone: 9999999999
 * ---------->If value not found that it will pop a message of contact not found
 * ---------->Enter choice 3 to check final result and then exit the code
 * 3
 * All Contacts:
 * Name: Kavish, Phone: 9012345687
 * 7
 * ---------->Returns to Main Menu
 * 1------Calendar
 * 2------PhoneBook
 * 3------MusicPlaylist
 * 4------Exit
 * Enter Choice :3
 * Menu:
 * 1. Add Song
 * 2. Remove Song
 * 3. Shuffle Playlist
 * 4. Display Playlist
 * 5. Display Song Details by Title
 * 6. Display Songs by Artist
 * 7. Get Song Count
 * 8. Clear Playlist
 * 9. Exit
 * ---------->Main menu appears
 * ---------->Choose 1
 * 1
 * Enter song title: Jiya jaaye na
 * Enter artist: Prashant Katheriya
 * ---------->Choose 4 to view the playlist
 * 4
 * Playlist:
 * 1. Jiya jaaye na by Prashant Katheriya
 * ---------->Add few more songs
 * 1
 * Enter song title: abc
 * Enter artist: pqr
 * 1
 * Enter song title: xyz
 * Enter artist: rst
 * 1
 * Enter song title: lmn
 * Enter artist: opq
 * ---------->Choose 4 to view playlist
 * 4
 * Playlist:
 * 1. Jiya jaaye na by Prashant Katheriya
 * 2. abc by pqr
 * 3. xyz by rst
 * 4. lmn by opq
 * ---------->Choose 3 to shuffle playlist
 * 3
 * Playlist shuffled.
 * 4
 * 1. Jiya jaaye na by Prashant Katheriya
 * 2. lmn by opq
 * 3. abc by pqr
 * 4. xyz by rst
 * ---------->Shuffled playlist
 * ---------->Choose 5 to get details of songs
 * 5
 * Enter song title: lmn
 * Song Details:
 * Title: lmn
 * Artist: opq
 * ---------->Choose 6 to get song by artist
 * 6
 * Enter artist: rst
 * Songs by rst:
 * 1. xyz by rst
 * ---------->Choose 7 to get count of songs
 * 7
 * Total songs in the playlist: 4
 * ---------->Choose 2 to remove specified song
 * 2
 * Enter song title to remove: xyz
 * ---------->Choose 4 to see the playlist
 * Playlist:
 * 1. Jiya jaaye na by Prashant Katheriya
 * 2. lmn by opq
 * 3. abc by pqr
 * ---------->Choose 8 to clear the playlist
 * 8
 * Playlist cleared.
 * ---------->Choose 4 to see the playlist
 * playlist:
 * ---------->Choose 9 to exit the code
 * 9
 * 1------Calendar
 * 2------PhoneBook
 * 3------MusicPlaylist
 * 4------Exit
 * Enter Choice :
 * Choose 4 to Terminate the code
 * 4
 * Thank You!!
 */