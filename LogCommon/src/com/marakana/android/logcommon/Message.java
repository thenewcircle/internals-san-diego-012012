package com.marakana.android.logcommon;

import android.os.Parcel;
import android.os.Parcelable;

public class Message implements Parcelable {
	public int priority;
	public String tag;
	public String text;

	/** Constructor using fields. */
	public Message(int priority, String tag, String text) {
		super();
		this.priority = priority;
		this.tag = tag;
		this.text = text;
	}
	
	public Message(Parcel parcel) {
		this( parcel.readInt(), parcel.readString(), parcel.readString() );
	}

	/** Factory for creating Message from a Parcel and a Message array. */
	public static Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {

		@Override
		public Message createFromParcel(Parcel parcel) {
			return new Message(parcel);
		}

		@Override
		public Message[] newArray(int size) {
			return new Message[size];
		}
	};
	
	@Override
	public int describeContents() {
		return 0;
	}

	/** Writes data to the parcel. */
	@Override
	public void writeToParcel(Parcel parcel, int flag) {
		parcel.writeInt(priority);
		parcel.writeString(tag);
		parcel.writeString(text);
	}

}
