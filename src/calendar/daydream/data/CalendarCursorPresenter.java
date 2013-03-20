package calendar.daydream.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract.Instances;

public class CalendarCursorPresenter {

	public static final String[] CURSOR_PROJECTION = new String[] {
			Instances._ID, Instances.EVENT_ID,
			Instances.BEGIN,
			Instances.TITLE,
			Instances.HAS_ALARM,
			Instances.EVENT_LOCATION,
			Instances.DISPLAY_COLOR
	};

	private Cursor cursor;
	private Context context;
	
	public CalendarCursorPresenter(Cursor cursor, Context context) {
		this.cursor = cursor;
		this.context = context;
	}

	public int getColor() {
		return getInt(Instances.DISPLAY_COLOR);
	}
	
	public String getTitle() {
		return getString(Instances.TITLE);
	}

	public String getLocation() {
		return getString(Instances.EVENT_LOCATION);
	}

	public int getEventId() {
		return getInt(Instances.EVENT_ID);
	}
	
	public String getDate() {
		DateFormat formatter = android.text.format.DateFormat.getDateFormat(context);

		return formatter.format(getCalendar(Instances.BEGIN).getTime());
	}

	public String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(getCalendar(Instances.BEGIN).getTime());
	}

	private String getString(String key) {
		int column = cursor.getColumnIndex(key);
		return cursor.getString(column);
	}

	private int getInt(String key) {
		int column = cursor.getColumnIndex(key);
		return cursor.getInt(column);
	}
	
	private boolean getBoolean(String key) {
		return getInt(key) == 1;
	}
	
	private Calendar getCalendar(String key) {
		int column = cursor.getColumnIndex(key);
		long value = cursor.getLong(column);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(value);

		return calendar;
	}

//	public boolean isNotToday() {
//		Calendar tomorrow = Calendar.getInstance();
//		tomorrow.set(Calendar.HOUR, 0);
//		tomorrow.set(Calendar.MINUTE, 0);
//		tomorrow.set(Calendar.SECOND, 0);
//		tomorrow.add(Calendar.DATE, 1);
//
//		return getCalendar(Instances.BEGIN).before(tomorrow);
//	}
//
//	public boolean isSoon() {
//		if(getBoolean(Instances.HAS_ALARM)) {
//			ContentResolver cr = context.getContentResolver();
//			cr.
//			//TODO look in remninder table
//			return true;
//		}
//		return false;
//	}
}
