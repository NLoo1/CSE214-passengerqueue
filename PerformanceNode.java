/*
PerformanceNode
First class of a three-part program. Simple class to act as an array index.
 */


public class PerformanceNode {

    private String performanceName;
    private String leadPerformer;
    private int totalParticipants;
    private int durationPerformance;
    private int startTime;

    private PerformanceNode prev;
    private PerformanceNode next;

    public PerformanceNode getPrev() {
        return prev;
    }

    public void setPrev(PerformanceNode prev) {
        this.prev = prev;
    }

    public PerformanceNode getNext() {
        return next;
    }

    public void setNext(PerformanceNode next) {
        this.next = next;
    }

    // Constructors + get/set

    public PerformanceNode() {
        next = null;
        prev = null;
    }

    public PerformanceNode(String performanceName, String leadPerformer, int totalParticipants, int durationPerformance, int startTime) {
        this.performanceName = performanceName;
        this.leadPerformer = leadPerformer;
        this.totalParticipants = totalParticipants;
        this.durationPerformance = durationPerformance;
        this.startTime = startTime;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public String getLeadPerformer() {
        return leadPerformer;
    }

    public void setLeadPerformer(String leadPerformer) {
        this.leadPerformer = leadPerformer;
    }

    public int getTotalParticipants() {
        return totalParticipants;
    }

    public void setTotalParticipants(int totalParticipants) {
        this.totalParticipants = totalParticipants;
    }

    public int getDurationPerformance() {
        return durationPerformance;
    }

    public void setDurationPerformance(int durationPerformance) {
        this.durationPerformance = durationPerformance;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public String toString() {
        return "PerformanceNode{" +
                "performanceName='" + performanceName + '\'' +
                ", leadPerformer='" + leadPerformer + '\'' +
                ", totalParticipants=" + totalParticipants +
                ", durationPerformance=" + durationPerformance +
                ", startTime=" + startTime +
                '}';
    }
}
