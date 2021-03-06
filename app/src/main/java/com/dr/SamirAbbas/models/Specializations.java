package com.dr.SamirAbbas.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.dr.SamirAbbas.activities.BaseActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by Anurag on 4/13/2018.
 */
public class Specializations implements Parcelable {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("data")
    @Expose
    private Data data;
    public final static Parcelable.Creator<Specializations> CREATOR = new Creator<Specializations>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Specializations createFromParcel(Parcel in) {
            return new Specializations(in);
        }

        public Specializations[] newArray(int size) {
            return (new Specializations[size]);
        }

    }
            ;

    protected Specializations(Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public Specializations() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(type);
        dest.writeValue(text);
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }

    public static class Data implements Parcelable
    {

        @SerializedName("specializations")
        @Expose
        private List<Specialization> specializations = null;
        public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            public Data[] newArray(int size) {
                return (new Data[size]);
            }

        }
                ;

        protected Data(Parcel in) {
            in.readList(this.specializations, (com.dr.SamirAbbas.models.Specializations.Specialization.class.getClassLoader()));
        }

        public Data() {
        }

        public List<Specialization> getSpecializations() {
            return specializations;
        }

        public void setSpecializations(List<Specialization> specializations) {
            this.specializations = specializations;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(specializations);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Specialization implements Parcelable
    {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("date")
        @Expose
        private String date;


        @SerializedName("name_ar")
        @Expose
        private String name_ar;

        public final static Parcelable.Creator<Specialization> CREATOR = new Creator<Specialization>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Specialization createFromParcel(Parcel in) {
                return new Specialization(in);
            }

            public Specialization[] newArray(int size) {
                return (new Specialization[size]);
            }

        }
                ;

        protected Specialization(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.name = ((String) in.readValue((String.class.getClassLoader())));
            this.date = ((String) in.readValue((String.class.getClassLoader())));
            this.name_ar = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Specialization() {
        }

        public String getName_ar() {
            return name_ar;
        }

        public void setName_ar(String name_ar) {
            this.name_ar = name_ar;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            if(BaseActivity.IsEnglish == false && name_ar != null && name_ar.length() > 0){
                return name_ar;
            }
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(name);
            dest.writeValue(date);
            dest.writeValue(name_ar);
        }

        public int describeContents() {
            return 0;
        }

    }

}