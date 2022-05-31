package model;

import java.util.ArrayList;

public class GtReportedObject {
    public Meta meta;
    public Pagination pagination;
    public ArrayList<Datum> data;


    public class Address{
        public int id;
        public int gt_id;
        public String status;
        public String province_name;
        public String province_code;
        public String district_code;
        public String district_name;
        public String ward_code;
        public String ward_name;
        public String address;
        public double latitude;
        public double longitude;
    }
  
    public class Datum{
        public int id;
        public int gt_id;
        public int sale_id;
        public String reason_code;
        public String reason_detail;
        public String report_image_1;
        public String report_image_2;
        public Object format;
        public String created_by;
        public Object updated_by;
        public int created_at;
        public int updated_at;
        public Object deleted_at;
        public String status;
        public String description;
        public Gt gt;
        public Sale sale;
    }
  
    public class Gt{
        public int id;
        public String code;
        public String name;
        public int level;
        public String status;
        public boolean kpis_ignored;
        public int created_at;
        public int updated_at;
        public String created_by;
        public String updated_by;
        public Profile profile;
        public ArrayList<Address> addresses;
        public Object routes;
    }
  
    public class Meta{
        public int code;
        public String message;
    }
  
    public class Pagination{
        public int page_size;
        public int page_offset;
        public int total_records;
        public int total_pages;
    }
  
    public class Profile{
        public int id;
        public int gt_id;
        public String trade_name;
        public String license_number;
        public int issue_date;
        public String issue_agency;
        public String merchant_code;
        public String phone;
        public String source;
        public Object size;
        public String images;
        public Object description;
        public Object note;
        public String email;
        public String owner_name;
        public String owner_identity_number;
        public int owner_identity_issue_date;
        public String owner_identity_issue_agency;
        public int owner_gender;
        public String owner_phone;
        public String owner_email;
        public int owner_dob;
        public int loyalty_tier_id;
        public int l1_onboarded_at;
        public String l1_onboarded_by;
        public String source_service;
        public String format;
        public String transport_infras;
        public int served_status;
        public int gt_format_id;
        public int created_at;
        public int updated_at;
    }
  
    public class Sale{
        public int id;
        public String code;
        public int parent_id;
        public String full_name;
        public String gender;
        public String channel;
        public Object channel_refer_id;
        public String type;
        public String identity_number;
        public String phone;
        public String email;
        public String address;
        public String status;
        public String created_by;
        public String updated_by;
        public String work_place_name;
        public String work_place_code;
        public String hrs_code;
        public int join_date;
        public int created_at;
        public int updated_at;
        public int dob;
    }
  
  
}
