public class ArrayObjectLog implements ObjectLogInterface 
{
  protected String name;              // name of this log
  protected Object [] log;             // array that holds log strings
  protected int lastIndex = -1;       // index of last string in array 

public ArrayObjectLog(String name, int maxSize)
// Precondition:   maxSize > 0
//
// Instantiates and returns a reference to an empty StringLog object 
// with name "name" and room for maxSize strings.
{
  log = new Object [maxSize];
  this.name = name;
}

public ArrayObjectLog(String name) 
// Instantiates and returns a reference to an empty StringLog object 
// with name "name" and room for 100 strings.
{
  log = new Object [100];
  this.name = name;
}

public void insert(Object element)
// Precondition:   This StringLog is not full.
//
// Places element into this StringLog.
{      
  lastIndex++;
  log[lastIndex] = element;
} 

public void clear()
			 // Makes this StringLog empty.
			 {   
 			   for (int i = 0; i <= lastIndex; i++)
			     log[i] = null;
 			   lastIndex = -1;
			 }

public boolean isFull()
// Returns true if this StringLog is full, otherwise returns false.
{              
  if (lastIndex == (log.length - 1)) 
    return true;
  else
    return false;
}

public int size()
// Returns the number of Strings in this StringLog.
{
  return (lastIndex + 1);
}

public String getName()
// Returns the name of this StringLog.
{
  return name;
}

public String toString()
// Returns a nicely formatted string representing this StringLog.
{
  String logString = "Log: " + name + "\n\n";
  for (int i = 0; i <= lastIndex; i++)
    logString = logString + (i+1) + ". " + log[i] + "\n";
  return logString;
}

public boolean contains(Object element)
// Returns true if element is in this StringLog
// otherwise returns false.
// Ignores case differences when doing string comparison.
{                 
  boolean moreToSearch;
  int location = 0;
  boolean found = false;
  moreToSearch = (location <= lastIndex);
  while (moreToSearch && !found) 
  {
    if (element.equals(log[location]))  // if they match
      found = true;
    else
    {
      location++;
      moreToSearch = (location <= lastIndex);
    }
  }
  return found;
} 




}