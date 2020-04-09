package com.member.buybackbazaar.retrofit;

public class EndPoints {

    // Live URL
    public static final String BASE_URL="https://dev-apiv3.asancash.com/"; // DevEnvirnment
 //   public static final String BASE_URL="https://apiv3.asancash.com/"; // StagingEnvirnment
 //   public static final String BASE_URL="https://apiv5.buybackbazaar.com/"; // ProductionEnvirnment
  //  public static final String BASE_URL="https://uat-apiv3.asancash.com/"; // UATEnvirnment
 //   public static final String BASE_URL="https://ref-apiv3.asancash.com/"; // RefEnvirnment

    // ImageUpload URL
    public  static  final String IMAGE_UPLOAD_URL = "https://devasancashcom.s3.eu-west-2.amazonaws.com/";
/*    public  static  final String IMAGE_UPLOAD_URL = "https://stageasancashcom.s3.eu-west-2.amazonaws.com/";
    public  static  final String IMAGE_UPLOAD_URL = "https://cdn.buybackbazaar.com/";
    public  static  final String IMAGE_UPLOAD_URL = "https://asancashdotcom.s3.eu-west-2.amazonaws.com/";
    public  static  final String IMAGE_UPLOAD_URL = "https://devasancashcom.s3.eu-west-2.amazonaws.com/";*/




    
    // API ENDPOINTS

    public static final String login = "is/identity/member/login";
    public static final String forgotPassowrd = "is/identity/forgot-password";
    public static final String resetPassword = "is/identity/reset-password";
    public static final String category = "as/category/active-list-with-brand";
    public static final String refershtoken = "is/identity/token";
    public static final String getAllAssets = "as/assets/with-bid-details/";
    public static final String getAllMyAssets = "as/assets/with-bid-details-of-store/";
    public static final String logout = "is/identity/logout";
    public static final String getMemberAccountStatements = "ms/member/accountStatemnts/getMemberAccountStmtbyFilter";
    public static final String getStoreInfo = "as/admin/store/getStoreInfo/";
    public static final String getMyDealsUsingPost = "cs/appraisal/";
    public static final String getMyDealsUsingPostInventory = "cs/appraisal/inventory-report";
    public static final String WatchDealExcution = "cs/appraisal/process";
    public static final String inventoryByStatusNewApp = "ms/admin/appraisal/inventoryByStatusNewApp/";
    public static final String liststatus = "cs/appraisal/list-status";
    public static final String getItemCondition = "as/admin/itemCondition/getItemCondition/";
    public static final String getAppraisalInfoFromBarCode = "ms/member/appraisals/getAppraisalInfoFromBarCode/";
    public static final String getAppraisalInfoFromCode = "cs/appraisal";
    public static final String calculateChangeCondition = "cs/asset-condition/validate-asset";
    public static final String inventoryMIS = "ms/member/inventoryMIS/";
    public static final String inventoryMISNew = ";ms/inventory/MIS/NewApp/";
    public static final String approvedamount = "as/bids/approved-amount";
    public static final String bids = "as/bids";
    public static final String watcBids = "cs/auction/bid";
    public static final String getAllDocuments = "as/admin/documents/getAllDocuments";
    public static final String upload = "cs/files/upload";
    public static final String secureupload = "cs/secure/files/upload";
    public static final String approveAppraisal = "ms/member/appraisals/approveAppraisal";
    public static final String getExtentionDate = "cs/member/getExtentionDate/";
    public static final String groups = "as/assets/groups/";
    public static final String barcode = "ms/member/verfiy/barcode";
    public static final String closeAppraisal = "ms/member/appraisals/closeAppraisal";
    public static final String closeAppraisalDeal = "cs/appraisal/close";
    public static final String calculateExtension = "cs/customer/appraisal/calculateExtension";
    public static final String extend = "cs/appraisal/extend";
    public static final String ratingconfiguration = "as/configuration/rating/";
    public static final String rating = "is/rating";
    public static final String verifyBarCode = "ms/inventory/asset/verifyBarCode";
    public static final String confirmCheckOutIn = "ms/inventory/asset/confirmCheckOutIn";
    public static final String checkout = "ms/member/inventory/checkout/";
    public static final String checkin = "ms/member/inventory/checkin/";
    public static final String updatePassword = "is/identity/change-password";
    public static final String ranks = "as/bids/ranks/";
    public static final String detailsRank = "as/assets/with-bid-details-by-rank";
    public static final String requestasset = "cs/request-asset";
    public static final String reject = "cs/appraisal/reject";
    public static final String validatebarcode = "cs/appraisal/validate-barcode";
    
}
