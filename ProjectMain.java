import java.security.InvalidParameterException;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class ProjectMain {
    public static void mainMenu() {
        System.out.println("University Library System");
        System.out.println("Menu Options");
        System.out.println("1. New Membership");
        System.out.println("2. New Collection");
        System.out.println("3. Remove Membership");
        System.out.println("4. Remove Collection");
        System.out.println("5. New Employee");
        System.out.println("6. Borrow Item");
        System.out.println("7. Return Item");
        System.out.println("8. Check overdues");
        System.out.println("9. Quit");
        System.out.println("");
    }

    public static Member newMemberEvent(Scanner scn) {
        System.out.println("Enter Membership Info: ");
        while (true) {
            try {
                System.out.print("Enter Membership Type (Student, Professor, External): ");
                String memType = scn.nextLine();

                System.out.print("Enter Member Name: ");
                String name = scn.nextLine();

                System.out.print("Enter Member Address: ");
                String address = scn.nextLine();

                System.out.print("Enter Member Date of Birth (dd-MMM-yyyy): ");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                Date dob = formatter.parse(scn.nextLine());

                System.out.print("Enter Member email: ");
                String email = scn.nextLine();

                System.out.print("Enter Member SSN (no dashes): ");
                int ssn = scn.nextInt();
                scn.nextLine();

                System.out.print("Enter member id: ");
                int memberID = scn.nextInt();
                scn.nextLine();

                if (memType.equals("Student")) {
                    System.out.print("Enter School: ");
                    String school = scn.nextLine();

                    System.out.print("Enter Major: ");
                    String major = scn.nextLine();

                    System.out.print("Enter Student ID: ");
                    int studentID = scn.nextInt();
                    scn.nextLine();

                    Member mem = new Student(name, address, dob, email, ssn, memberID, school, major, studentID);
                    return mem;
                } else if (memType.equals("Professor")) {
                    System.out.print("Enter Department: ");
                    String dept = scn.nextLine();
                    Member mem = new Professor(name, address, dob, email, ssn, memberID, dept);
                    return mem;
                } else if (memType.equals("External")) {
                    Member mem = new External(name, address, dob, email, ssn, memberID);
                    return mem;
                } else {
                    throw new InvalidParameterException(
                            "Error in ProjectMain.newMemberEvent: Attempted to create member with invalid membership type");
                }
            } catch (ParseException | InvalidParameterException e) {
                e.printStackTrace();
                System.out.print("Try again. ");
            }
        }
    }

    public static Member newRemoveMemberEvent(Scanner scn, List<Member> members) {
        System.out.print("Enter the Member ID to remove: ");
        int memberID = scn.nextInt();
        scn.nextLine();
        Member memberToRemove = null;

        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                memberToRemove = member;
                break;
            }
        }

        if (memberToRemove != null) {
            members.remove(memberToRemove);
            System.out.println("Member with ID " + memberID + " has been removed.");
            return memberToRemove;
        } else {
            System.out.println("No member found with ID " + memberID);
            return null;
        }
    }

    public static Employee newEmployeeEvent(Scanner scn) {
        try {
            System.out.println("Enter Employee Info: ");

            System.out.print("Enter Employee Type (Librarian, Technician): ");
            String empType = scn.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = scn.nextLine();

            System.out.print("Enter Employee Address: ");
            String address = scn.nextLine();

            System.out.print("Enter Employee Date of Birth (dd-MMM-yyyy): ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date dob = formatter.parse(scn.nextLine());

            System.out.print("Enter Employee email: ");
            String email = scn.nextLine();

            System.out.print("Enter Employee SSN (no dashes): ");
            int ssn = scn.nextInt();
            scn.nextLine();

            System.out.print("Enter Employee ID: ");
            int employeeID = scn.nextInt();
            scn.nextLine();

            if (empType.equals("Librarian")) {
                Employee emp = new Librarian(name, address, dob, email, ssn, employeeID);
                return emp;
            } else if (empType.equals("Technician")) {
                Employee emp = new Technician(name, address, dob, email, ssn, employeeID);
                return emp;
            } else {
                throw new InvalidParameterException(
                        "Error in ProjectMain.newMemberEvent: Attempted to create member with invalid membership type");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Invalid date format. Please try again.");
            return null;
        }
    }

    public static LibraryCollection newCollectionEvent(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter Collection Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Collection ID: ");
                String id = scanner.nextLine();
                LibraryCollection lc = new LibraryCollection(name, id);
                System.out.print("Would you like to add an item (Yes/No)? ");
                String outcome = scanner.nextLine();
                while (outcome.equals("Yes")) {
                    try {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Publication date: (dd-Mmm-yyyy): ");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
                        LocalDate pub_Date = LocalDate.parse(scanner.nextLine(), formatter);

                        System.out.print("Enter number of authors: ");
                        int authorsCount = scanner.nextInt();
                        scanner.nextLine();
                        String[] authors = new String[authorsCount];
                        if (authorsCount <= 0)
                            throw new InvalidParameterException("Count must not be 0 or less.");
                        for (int i = 0; i < authorsCount; i++) {
                            System.out.print("Enter author: ");
                            authors[i] = scanner.nextLine();
                        }

                        System.out.print("Enter item type (Book, DVD, Newspaper, Journal): ");
                        String input = scanner.nextLine();
                        if (input.equals("Book")) {
                            System.out.print("Enter ISBN (no dashes): ");
                            long isbn = scanner.nextLong();
                            scanner.nextLine();
                            Item it = new Book(isbn, title, pub_Date, authors);
                            lc.addItem(it);
                        } else if (input.equals("DVD")) {
                            System.out.print("Enter ISBN (no dashes): ");
                            long isbn = scanner.nextLong();
                            scanner.nextLine();
                            Item it = new DVD(isbn, title, pub_Date, authors);
                            lc.addItem(it);
                        } else if (input.equals("Newspaper")) {
                            System.out.print("Enter ISSN (no dashes): ");
                            int issn = scanner.nextInt();
                            scanner.nextLine();
                            Item it = new Newspaper(issn, title, pub_Date, authors);
                            lc.addItem(it);
                        } else if (input.equals("Journal")) {
                            System.out.print("Enter ISSN (no dashes): ");
                            int issn = scanner.nextInt();
                            scanner.nextLine();
                            Item it = new Journal(issn, title, pub_Date, authors);
                            lc.addItem(it);
                        } else
                            throw new InvalidParameterException();

                        System.out.print("Would you like to add another item (Yes/No)? ");
                        outcome = scanner.nextLine();
                    } catch (InvalidParameterException | DateTimeParseException e) {
                        e.printStackTrace();
                        System.out.println("Try again.");
                    }
                }
                return lc;
            } catch (InvalidParameterException e) {
                e.printStackTrace();
                System.out.println("Try again.");
            }
        }

    }

    public static LibraryCollection newRemoveCollectionEvent(Scanner scn, List<LibraryCollection> libraryCollections) {
        System.out.print("Enter the Collection ID to remove: ");
        String libraryCollectionID = scn.nextLine();
        LibraryCollection libraryCollectionToRemove = null;

        for (LibraryCollection libraryCollection : libraryCollections) {
            if (libraryCollection.getID().equals(libraryCollectionID)) {
                libraryCollectionToRemove = libraryCollection;
                break;
            }
        }

        if (libraryCollectionToRemove != null) {
            libraryCollections.remove(libraryCollectionToRemove);
            System.out.println("Collection with ID " + libraryCollectionID + " has been removed.");
            return libraryCollectionToRemove;
        } else {
            System.out.println("No collection found with ID " + libraryCollectionID);
            return null;
        }
    }

    public static void newBorrowsEvent(Scanner scn, List<Member> members, List<LibraryCollection> collections, int holdTime) {
        try {
            System.out.print("Enter Member ID: ");
            int memberID = scn.nextInt();
            scn.nextLine();
            Member memberSignedIn = null;

            for (Member member : members) {
                if (member.getMemberID() == memberID) {
                    memberSignedIn = member;
                    break;
                }
            }

            if (memberSignedIn == null) {
                System.out.print("Member not found.");
                throw new InvalidParameterException();
            }

            System.out.print("Enter Item Type (Book, DVD, Journal, Newspaper): ");
            String itemType = scn.nextLine();
            if (itemType.equals("Book")) {
                System.out.print("Search Book by ISBN (no dashes): ");
                long isbn = scn.nextLong();
                scn.nextLine();
                Item itemToBorrow = null;
                for (ISBNItem item : findISBN(isbn, collections)) {
                    if (!item.isBorrowed()) {
                        itemToBorrow = item;
                        break;
                    }
                }
                if (itemToBorrow == null) {
                    System.out.println("Item unavailable.");
                    throw new InvalidParameterException();
                }
                memberSignedIn.addItem(itemToBorrow);
                itemToBorrow.setBorrowedDate(LocalDate.now());
                itemToBorrow.print();
                itemToBorrow.printOverdueInfo(holdTime);
            } else if (itemType.equals("DVD")) {
                System.out.print("Search DVD by ISBN (no dashes): ");
                long isbn = scn.nextLong();
                scn.nextLine();
                Item itemToBorrow = null;
                for (ISBNItem item : findISBN(isbn, collections)) {
                    if (!item.isBorrowed()) {
                        itemToBorrow = item;
                        break;
                    }
                }
                if (itemToBorrow == null) {
                    System.out.println("Item unavailable.");
                    throw new InvalidParameterException();
                }
                memberSignedIn.addItem(itemToBorrow);
                itemToBorrow.setBorrowedDate(LocalDate.now());
                itemToBorrow.print();
                itemToBorrow.printOverdueInfo(holdTime);
            } else if (itemType.equals("Journal")) {
                System.out.print("Search Journal by ISSN (no dashes): ");
                int issn = scn.nextInt();
                scn.nextLine();
                Item itemToBorrow = null;
                for (ISSNItem item : findISSN(issn, collections)) {
                    if (!item.isBorrowed()) {
                        itemToBorrow = item;
                        break;
                    }
                }
                if (itemToBorrow == null) {
                    System.out.println("Item unavailable.");
                    throw new InvalidParameterException();
                }
                memberSignedIn.addItem(itemToBorrow);
                itemToBorrow.setBorrowedDate(LocalDate.now());
                itemToBorrow.print();
                itemToBorrow.printOverdueInfo(holdTime);
            } else if (itemType.equals("Newspaper")) {
                System.out.print("Search Newspaper by ISSN (no dashes): ");
                int issn = scn.nextInt();
                scn.nextLine();
                Item itemToBorrow = null;
                for (ISSNItem item : findISSN(issn, collections)) {
                    if (!item.isBorrowed()) {
                        itemToBorrow = item;
                        break;
                    }
                }
                if (itemToBorrow == null) {
                    System.out.println("Item unavailable.");
                    throw new InvalidParameterException();
                }
                memberSignedIn.addItem(itemToBorrow);
                itemToBorrow.setBorrowedDate(LocalDate.now());
                itemToBorrow.print();
                itemToBorrow.printOverdueInfo(holdTime);
            } else {
                throw new InvalidParameterException(
                        "Error in ProjectMain.newBorrowsEvent: Attempted search for item type that does not exist");
            }
        } catch (InvalidParameterException e) {
            System.out.println("Try again.");
        }
    }

    private static List<ISBNItem> findISBN(long isbn, List<LibraryCollection> collections) {
        List<ISBNItem> foundItems = new ArrayList<>();

        for (LibraryCollection collection : collections) {
            foundItems.addAll(collection.getItemsByISBN(isbn));
        }

        return foundItems;
    }

    private static List<ISSNItem> findISSN(int issn, List<LibraryCollection> collections) {
        List<ISSNItem> foundItems = new ArrayList<>();

        for (LibraryCollection collection : collections) {
            foundItems.addAll(collection.getItemsByISSN(issn));
        }

        return foundItems;
    }

    public static void newReturnEvent(Scanner scn, List<Member> members) {
        try {
            System.out.print("Enter Member ID: ");
            int memberID = scn.nextInt();
            scn.nextLine();
            Member memberSignedIn = null;

            for (Member member : members) {
                if (member.getMemberID() == memberID) {
                    memberSignedIn = member;
                    break;
                }
            }
            if (memberSignedIn == null) {
                System.out.print("Member not found.");
                throw new InvalidParameterException();
            }

            System.out.print("Enter Item Type (Book, DVD, Journal, Newspaper): ");
            String itemType = scn.nextLine();
            if (itemType.equals("Book")) {
                System.out.print("Search Book by ISBN (no dashes): ");
                long isbn = scn.nextLong();
                scn.nextLine();

                memberSignedIn.getBookItem(isbn).setBorrowedDate(null);
                memberSignedIn.removeBookItem(isbn);
            } else if (itemType.equals("DVD")) {
                System.out.print("Search DVD by ISBN (no dashes): ");
                long isbn = scn.nextLong();
                scn.nextLine();

                memberSignedIn.getBookItem(isbn).setBorrowedDate(null);
                memberSignedIn.removeBookItem(isbn);
            } else if (itemType.equals("Journal")) {
                System.out.print("Search Journal by ISSN (no dashes): ");
                int issn = scn.nextInt();
                scn.nextLine();

                memberSignedIn.getSerialItem(issn).setBorrowedDate(null);
                memberSignedIn.removeSerialItem(issn);
            } else if (itemType.equals("Newspaper")) {
                System.out.print("Search Newspaper by ISSN (no dashes): ");
                int issn = scn.nextInt();
                scn.nextLine();

                memberSignedIn.getSerialItem(issn).setBorrowedDate(null);
                memberSignedIn.removeSerialItem(issn);
            } else {
                throw new InvalidParameterException(
                        "Error in ProjectMain.newReturnEvent: Attempted search for item type that does not exist");
            }
        } catch (InvalidParameterException e) {
            System.out.println("Try again.");
        }
    }

    private static void newCheckOverduesEvent(List<LibraryCollection> collections, int holdTime) {
        for (LibraryCollection collection : collections) {
            collection.printOverdues(holdTime);
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        List<LibraryCollection> libraryCollections = new ArrayList<>();
        int holdTime = -10;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                ProjectMain.mainMenu();
                System.out.print("Enter your option number: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        members.add(ProjectMain.newMemberEvent(scanner));
                        break;
                    case 2:
                        libraryCollections.add(ProjectMain.newCollectionEvent(scanner));
                        break;
                    case 3:
                        ProjectMain.newRemoveMemberEvent(scanner, members);
                        break;
                    case 4:
                        ProjectMain.newRemoveCollectionEvent(scanner, libraryCollections);
                        break;
                    case 5:
                        Employee newEmployee = ProjectMain.newEmployeeEvent(scanner);
                        if (newEmployee != null) {
                            employees.add(newEmployee);
                            System.out.println("Employee added successfully.");
                        }
                        break;
                    case 6:
                        ProjectMain.newBorrowsEvent(scanner, members, libraryCollections, holdTime);
                        break;
                    case 7:
                        ProjectMain.newReturnEvent(scanner, members);
                        break;
                    case 8:
                        ProjectMain.newCheckOverduesEvent(libraryCollections, holdTime);
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid operator.");
                }

                System.out.println();
            }
        }
    }
}