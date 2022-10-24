import jdk.jshell.spi.ExecutionControlProvider;

/*
PerformanceList
Second part of a three-part program. Attempts to replicate LinkedList functionality
 */
public class PerformanceList {

    private PerformanceNode head;
    private PerformanceNode tail;
    private PerformanceNode cursor;

    private PerformanceNode[] list;


    // New methods

    public void displayAllNodes(){
        if(cursor == null) System.out.println("no nodes");
        else {
            cursor = head;
            System.out.println(cursor.toString());
            while (cursor.getNext() != null || cursor != tail) { // while cursor is not at tail and not past the specified position
                if(cursor == cursor.getNext()){
                    return;
                }else {
                    cursor = cursor.getNext();
                    System.out.println(cursor.toString());
//                    System.out.println("Help i'm stuck");
                }
            }
        }
    }

    public void addToEnd(PerformanceNode newPerformance){ // Move cursor to newly added node!!
        if(tail == null){ // If no performances in list
            tail = newPerformance;
            head = tail;
            cursor = head;
        }
        else{
            tail.setNext(newPerformance); // Add after tail
            tail.getNext().setPrev(tail); // Then, new tail's getPrev is prior tail
            tail = tail.getNext(); // Then, change tail
            tail.setNext(null);
            cursor = tail; // Then, move cursor
        }
    }


    // If current node is null, insert at end of list
    // Move cursor to newly added node
    public void addAfterCurrent(PerformanceNode newPerformance){
        if(cursor == null){
            addToEnd(newPerformance);
        }
        else{
            cursor.setNext(newPerformance); // Set next node to parameter
            cursor.getNext().setPrev(cursor); // Then, set next node's prev
            cursor = cursor.getNext(); // Then, move cursor;
        }
    }

    // Change cursor to node after removed node (before if no nodes after)
    // If only node, cursor is null
    public boolean removeCurrentNode(){
        if(cursor == head && cursor == tail){ // If only node
            cursor = null;
            head = null;
            tail = null;
            return false;
        }
        else if(cursor == head || cursor.getPrev() == null){ // If head
            head = head.getNext(); // Change head to next node
            head.getNext().setPrev(null); // Then, change current head's prev to null
            cursor = head;
            return true;
        }
        else if(cursor.getNext() == null || cursor == tail){ // If tail
            cursor.getPrev().setNext(null); // Set previous node's next node to null
            tail = cursor.getPrev(); // Then, previous node is now tail.
            cursor = tail; // Move cursor to tail.
            return true;
        }
        else{
//            tail = cursor.getPrev();
//            cursor.getPrev().setNext(null);
//            cursor = cursor.getPrev();
            cursor.getNext().setPrev(cursor.getPrev()); // Change next node's prevNode to two node before
            cursor.getPrev().setNext(cursor.getNext()); // Change prev node's next Node to two nodes after
            cursor = cursor.getNext();
            return true;
        }
    }

    public void displayCurrentPerformance(){
        if (cursor == null) System.out.println("No current performance");
        else System.out.println(cursor);
    }

    // Throw exception if no current node
    public boolean moveCursorForward() throws Exception {
        if(cursor == null) throw new Exception("No current node");
            else if(cursor.getNext() == null || cursor == tail) return false; // Cursor is already at tail
            cursor = cursor.getNext();
            return true;
    }


    public boolean moveCursorBackward() throws Exception {
        if(cursor == null) throw new Exception("No current node");
        else if(cursor.getPrev() == null || cursor == head) return false; // Cursor is already at head
        cursor = cursor.getPrev();
        return true;
    }

    // Assume first performance is pos 1
    // If pos does not exist, return false
    public boolean jumpToPosition(int position){
        int ct = 1 ;
        cursor = head;
        if (head == null) return false;
        while(cursor != tail && ct != position){ // while cursor is not at tail and not past the specified position
            cursor = cursor.getNext();
            ct++;
        }
        if(cursor == tail && ct != position) return false; // If reached end of list, but ct != pos
        else return true;
    }

    public PerformanceNode sortedMerge(PerformanceNode a, PerformanceNode b){
        PerformanceNode result = null;
        if(a == null) return b;
        if(b == null) return a;

        if(a.getStartTime() <= b.getStartTime()){
            result = a;
            result.setNext(sortedMerge(a.getNext(),b));
            result.setPrev(sortedMerge(a.getPrev(), b));
        }
        else{
            result = b;
            result.setNext(sortedMerge(a,b.getNext()));
            result.setPrev(sortedMerge(a, b.getPrev()));
        }
        return result;
    }

    public PerformanceNode mergeSort(PerformanceNode h){
        if(h == null || h.getNext() == null) return h;
        PerformanceNode middle = getMiddle(h);
        PerformanceNode nextofmiddle = middle.getNext();

        middle.setNext(null);

        PerformanceNode left = mergeSort(h);

        PerformanceNode right = mergeSort(nextofmiddle);

        PerformanceNode sortedlist = sortedMerge(left, right);
        return sortedlist;

    }

    public static PerformanceNode getMiddle(PerformanceNode head){
        if(head == null) return head;

        PerformanceNode slow = head, fast = head;

        while(fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    // Regular methods

    public PerformanceList() {
        head = null;
        tail = null;
        cursor = null;
        list = null;
    }

    public PerformanceList(PerformanceNode head, PerformanceNode tail, PerformanceNode cursor, PerformanceNode[] list) {
        this.head = head;
        this.tail = tail;
        this.cursor = cursor;
        this.list = list;
    }

    public PerformanceNode[] getList() {
        return list;
    }

    public void setList(PerformanceNode[] list) {
        this.list = list;
    }

    public PerformanceNode getHead() {
        return head;
    }

    public void setHead(PerformanceNode head) {
        this.head = head;
    }

    public PerformanceNode getTail() {
        return tail;
    }

    public void setTail(PerformanceNode tail) {
        this.tail = tail;
    }

    public PerformanceNode getCursor() {
        return cursor;
    }

    public void setCursor(PerformanceNode cursor) {
        this.cursor = cursor;
    }

    @Override
    public String toString() {
        return "PerformanceList{" +
                "head=" + head +
                ", tail=" + tail +
                ", cursor=" + cursor +
                '}';
    }
}
