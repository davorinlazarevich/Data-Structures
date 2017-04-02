public interface ObjectLogInterface
{
  void insert(Object element);
  // Precondition:   This StringLog is not full.
  // 
  // Places element into this StringLog.

  boolean isFull();
  // Returns true if this StringLog is full, otherwise returns false.
   
  int size();
  // Returns the number of Strings in this StringLog.

  boolean contains(Object element);
  // Returns true if element is in this StringLog, 
  // otherwise returns false.
  // Ignores case differences when doing string comparison.
  
  void clear();
  // Makes this StringLog empty.

  String getName();
  // Returns the name of this StringLog.

  String toString();
  // Returns a nicely formatted string representing this StringLog.
} 
