import java.util.Stack;

public class LinkList {
    private Link first;            // ref to first link on list

    public LinkList()              // constructor
    {
        first = null;               // no links on list yet
    }

    // -------------------------------------------------------------
    public void insertFirst(int id, double dd) {                           // make new link
        Link newLink = new Link(id, dd);
        newLink.next = first;       // it points to old first link
        first = newLink;            // now first points to this
    }

    // -------------------------------------------------------------
    public Link find(int key)      // find link with given key
    {                           // (assumes non-empty list)
        Link current = first;              // start at 'first'
        while (current.iData != key)        // while no match,
        {
            if (current.next == null)        // if end of list,
                return null;                 // didn't find it
            else                            // not end of list,
                current = current.next;      // go to next link
        }
        return current;                    // found it
    }

    // -------------------------------------------------------------
    public Link delete(int key)    // delete link with given key
    {                           // (assumes non-empty list)
        Link current = first;              // search for link
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;                 // didn't find it
            else {
                previous = current;          // go to next link
                current = current.next;
            }
        }                               // found it
        if (current == first) {               // if first link,
            first = first.next;//    change first
        } else {                               // otherwise,
            previous.next = current.next;   //    bypass it
            return current;
        }
        return current;
    }

    public void insertLast(int id, double dd) {
        Link newLink = new Link(id, dd);
        if (first == null) {
            first = newLink;
        } else {
            Link current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newLink;
        }
    }

    // Método para insertar después de un elemento específico
    public void insertAfter(int key, int id, double dd) {
        Link current = find(key);
        if (current != null) {
            Link newLink = new Link(id, dd);
            newLink.next = current.next;
            current.next = newLink;
        } else {
            System.out.println("No se puede insertar después de " + key + ". Elemento no encontrado.");
        }
    }

    // Método para eliminar el primer elemento de la lista
    public Link deleteFirst() {
        if (first != null) {
            Link temp = first;
            first = first.next;
            return temp;
        } else {
            System.out.println("No se puede eliminar. La lista está vacía.\n");
            return null;
        }
    }

    // Método para eliminar el último elemento de la lista
    public Link deleteLast() {
        if (first != null) {
            if (first.next == null) {
                Link temp = first;
                first = null;
                return temp;
            } else {
                Link current = first;
                Link previous = null;
                while (current.next != null) {
                    previous = current;
                    current = current.next;
                }
                previous.next = null;
                return current;
            }
        } else {
            System.out.println("No se puede eliminar. La lista está vacía.");
            return null;
        }
    }

    // Método para eliminar un elemento específico por su clave
//        public Link deleteByKey(int key) {
//                Link current = first;
//                Link previous = first;
//                while (current != null && current.iData != key) {
//                        previous = current;
//                        current = current.next;
//                }
//                if (current != null) {
//                        if (current == first) {
//                                first = first.next;
//                        } else {
//                                previous.next = current.next;
//                        }
//                        return current;
//                } else {
//                        System.out.println("No se puede eliminar. Elemento con clave " + key + " no encontrado.");
//                        return null;
//                }
//        }

    // -------------------------------------------------------------
    public void displayList()      // display the list
    {
        System.out.print("List (first-->last): ");
        Link current = first;       // start at beginning of list
        while (current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
        System.out.println();
    }

    // -------------------------------------------------------------
    public Link findFusionPoint(LinkList list2) {

        // Create two stacks to store nodes from both lists
        Stack<Link> stack1 = new Stack<>();
        Stack<Link> stack2 = new Stack<>();

        // Fill the first stack with nodes from the first list
        Link current1 = first;
        while (current1 != null) {
            stack1.push(current1);
            current1 = current1.next;
        }

        // Fill the second stack with nodes from the second list
        Link current2 = list2.first;
        while (current2 != null) {
            stack2.push(current2);
            current2 = current2.next;
        }

        // Initialize the intersection node as null
        Link intersection = null;

        // Compare the popped nodes from both stacks until they diverge
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            // Pop nodes from the stacks
            Link pop1 = stack1.pop();
            Link pop2 = stack2.pop();

            // Compare the values of the nodes
            if (pop1.iData == pop2.iData && pop1.dData == pop2.dData) {
                intersection = pop1; // Found the first intersection point
            } else {
                break; // Stop when the stacks diverge
            }
        }
        // Return the found intersection node or null if there is no intersection point
        return intersection;
    }

    // -------------------------------------------------------------
    public static void insertUnion(LinkList list1, LinkList list2, int key3, double value3) {
        list1.insertLast(key3, value3);
        list2.insertLast(key3, value3);
    }

    // -------------------------------------------------------------
    public static void deleteUnion(LinkList list1, LinkList list2) {
        list1.deleteLast();
        list2.deleteLast();
    }

    public static void printUnion() {
        System.out.println("Representación visual:\n"+
                           "{0, 0.0} → {22, 2.99} → {44, 4.99} → {66, 6.99} → {88, 8.99} →\n" +
                           "                                                               {99, 9.99} → {98, 9.98} → {97, 9.97}\n" +
                           "           {11, 1.99} → {33, 3.99} → {55, 5.99} → {77, 7.99} →\n");
    }

}// end class LinkList

