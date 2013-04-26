package za.co.immedia.ASCIITable;

import android.database.Cursor;
import android.util.Log;

import com.bethecoder.ascii_table.ASCIITable;

/**
 * <p>
 * Dependent: https://code.google.com/p/java-ascii-table/
 * </p>
 * Logger for Cursor's to help debug tables, it will output rows and columns, You may need to limit the columns due to Log wrapping
 * 
 * @author Duncan Dean Scholtz (duncandee@gmail.com)
 * 
 */
public class CursorASCIITable {
    private static final String TAG = "CursorASCIITable";

    /**
     * Generates the ASCIITable based on the cursor provided
     * 
     * @param c
     * @return The ASCIITable as a String
     */
    public static String getTable(Cursor c) {
        return getTable(c, null);
    }

    /**
     * @param c
     * @param limitToCols
     *            Limit column output
     * @return
     */
    public static String getTable(Cursor c, String[] limitToCols) {
        String table = "";
        if (c != null) {
            int limitCount = limitToCols == null ? c.getColumnCount() : limitToCols.length;

            String[] header = new String[limitCount];
            String[][] data = new String[limitCount][c.getCount()];

            if (limitToCols == null) {
                for (int i = 0; i < c.getColumnCount(); i++) {
                    header[i] = c.getColumnName(i);
                }
            } else {
                for (int i = 0; i < limitToCols.length; i++) {
                    header[i] = limitToCols[i];
                }
            }
            int count = 0;
            if (c.moveToFirst()) {
                do {
                    if (limitToCols == null) {

                        for (int i = 0; i < c.getColumnCount(); i++) {
                            data[i][count] = c.getString(count);
                        }
                    } else {
                        for (int i = 0; i < limitToCols.length; i++) {
                            data[i][count] = c.getString(c.getColumnIndex(limitToCols[i]));
                        }
                    }
                    count++;
                } while (c.moveToNext());
            }
            table = ASCIITable.getInstance().getTable(header, data);
        }

        return table;
    }

    /**
     * @param c
     */
    public static void d(Cursor c) {
        Log.d(TAG, getTable(c));
    }

    /**
     * @param c
     * @param limitToCols
     *            Limit column output
     */
    public static void d(Cursor c, String[] limitToCols) {
        Log.d(TAG, getTable(c));
    }

    /**
     * @param c
     */
    public static void i(Cursor c) {
        Log.i(TAG, getTable(c));
    }

    /**
     * @param c
     * @param limitToCols
     *            Limit column output
     */
    public static void i(Cursor c, String[] limitToCols) {
        Log.i(TAG, getTable(c));
    }

    /**
     * @param c
     */
    public static void e(Cursor c) {
        Log.e(TAG, getTable(c));
    }

    /**
     * @param c
     * @param limitToCols
     *            Limit column output
     */
    public static void e(Cursor c, String[] limitToCols) {
        Log.e(TAG, getTable(c));
    }

    /**
     * @param c
     */
    public static void w(Cursor c) {
        Log.w(TAG, getTable(c));
    }

    /**
     * @param c
     * @param limitToCols
     *            Limit column output
     */
    public static void w(Cursor c, String[] limitToCols) {
        Log.w(TAG, getTable(c));
    }

    /**
     * @param c
     */
    public static void v(Cursor c) {
        Log.v(TAG, getTable(c));
    }

    /**
     * @param c
     * @param limitToCols
     *            Limit column output
     */
    public static void v(Cursor c, String[] limitToCols) {
        Log.v(TAG, getTable(c));
    }

    /**
     * @param c
     */
    public static void wtf(Cursor c) {
        Log.wtf(TAG, getTable(c));
    }

    /**
     * @param c
     * @param limitToCols
     *            Limit column output
     */
    public static void wtf(Cursor c, String[] limitToCols) {
        Log.wtf(TAG, getTable(c));
    }
}
