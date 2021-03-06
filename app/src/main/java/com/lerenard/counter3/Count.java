package com.lerenard.counter3;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lerenard on 16-Aug-16.
 */
public class Count implements Parcelable {
    private long _id;
    private String name;
    private int count;

    public Count(long id, String n, int c) {
        _id = id;
        name = n;
        count = c;
    }

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    protected Count(Count count) {
        copyFrom(count);
    }

    protected Count(Parcel in) {
        name = in.readString();
        count = in.readInt();
        _id = in.readLong();
    }

    public static final Creator<Count> CREATOR = new Creator<Count>() {
        @Override
        public Count createFromParcel(Parcel in) {
            return new Count(in);
        }

        @Override
        public Count[] newArray(int size) {
            return new Count[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    Count(String n, int c) {
        this(-1, n, c);
    }

    Count(String n) {
        this(n, 0);
    }

    Count() {this("");}

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Count)) {
            return false;
        }
        Count rhs = (Count) obj;
        return _id == rhs._id && name.equals(rhs.name) && count == rhs.count;
    }

    public String toString() {
        return "<Count(" + _id + ", \"" + name + "\", " + count + ")>";
    }

    public String toBriefString() {
        String briefName = name;
        int newlineIndex = briefName.indexOf('\n');
        if (newlineIndex != -1) {
            briefName = briefName.substring(0, newlineIndex);
        }
        if (briefName.length() >= 10) {
            briefName = briefName.substring(0, 10);
        }
        if (!briefName.equals(name)) {
            briefName += "...";
        }
        return "<Count(" + _id + ", \"" + briefName + "\", " + count + ")>";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(count);
        dest.writeLong(_id);
    }

    public void copyFrom(Count count) {
        name = count.name;
        this.count = count.count;
        _id = count._id;
    }
}
