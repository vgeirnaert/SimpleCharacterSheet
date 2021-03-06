package net.mindsoup.charactersoup.util;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Valentijn on 27-2-2015.
 */
public class ListElement implements Parcelable {

    private String title;
    private String description;
    private int index;
    private String category;
    private boolean isExpanded = false;

    public ListElement() {
        this.setTitle("");
        this.setDescription("");
        this.setIndex(-1);
        this.setCategory("");
    }

    public ListElement(String title, String description, int index) {
        this.setTitle(title);
        this.setDescription(description);
        this.setIndex(index);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void expand() {
        this.isExpanded = true;
    }

    public void collapse() {
        this.isExpanded = false;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.getTitle());
        parcel.writeString(this.getDescription());
        parcel.writeInt(this.getIndex());
        parcel.writeString(this.getCategory());
    }

    public static final Parcelable.Creator<ListElement> CREATOR = new Parcelable.Creator<ListElement>() {
        public ListElement createFromParcel(Parcel in) {
            return new ListElement(in);
        }

        public ListElement[] newArray(int size) {
            return new ListElement[size];
        }
    };

    private ListElement(Parcel in) {
        this.setTitle(in.readString());
        this.setDescription(in.readString());
        this.setIndex(in.readInt());
        this.setCategory(in.readString());
    }
}
