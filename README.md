#Cursor ASCII Table

A helper to log / debug Android Cursors. <br/>
It will output a ASCII with the Cursors data in it.<br/>
There is a limitation with line wrapping in logcat, so you should limit it to the columns that are important.

###Dependency
* [java-ascii-table](https://code.google.com/p/java-ascii-table/)


###Usage

	String[] limit = new String[] { Contacts._ID, Contacts.DISPLAY_NAME };
    Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    
    CursorASCIITable.d(c, limit);