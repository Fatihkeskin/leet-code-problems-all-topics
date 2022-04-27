 public static void main(String args[])
    {

        Node head = newNode(1);
        head.next = newNode(0);
        head.next.next = newNode(0);
        head.next.next.next = newNode(0);

        System.out.print("List is ");
        printList(head);

        head = subtractOne(head);

        System.out.print("Resultant list is ");
        printList(head);
    }

    // Function to print a linked list
    static void printList(Node node)
    {

        // Iterate until node is null
        while (node != null)
        {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    static class Node
    {
        int data;
        Node next;
    };

    // Function to create a new node with
// the given data
    static Node newNode(int data)
    {

        // Create a new node
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;

        // Return the created node
        return new_node;
    }


    static Node subtractOne(Node head)
    {
        Node temp = head;
        subtractOneHelper(temp , 1);

        if (head.data == 0)
            head = head.next;
        return head;
    }

    static int subtractOneHelper(Node head, int borrow)
    {
        if (head== null)
            return borrow;
        borrow = subtractOneHelper(head.next, borrow);
        if (head.data - borrow < 0) {
            head.data = head.data - borrow + 10;
            borrow = 1;
        } else {
            head.data = head.data - borrow;
            borrow = 0;
        }
        return borrow;
    }