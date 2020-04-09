package com.member.buybackbazaar.helpers;//package com.example.startproject.helpers;
//
//import android.annotation.SuppressLint;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.pakonlinepk.ecommerce.model.CartModel;
//import com.pakonlinepk.ecommerce.model.RecentViewedModel;
//import com.pakonlinepk.ecommerce.retrofit.Keys;
//import com.pakonlinepk.ecommerce.retrofit.model.HomeProductDataModel;
//import com.pakonlinepk.ecommerce.retrofit.response.AllCategoryResponseModel;
//import com.pakonlinepk.ecommerce.retrofit.response.HomeResponseModel;
//import com.google.gson.Gson;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class DbManager extends SQLiteOpenHelper {
//
//	// Database version
//	private static final int DATABASE_VERSION = 1;
//
//	// Database name
//	private static final String DATABASE_NAME = "e_store_db";
//
//	/////////// Database table columns ////////////
//
//	private static final String KEY_PRODUCT_ID = "product_id";
//	private static final String KEY_PRODUCT_NAME = "product_name";
//	private static final String KEY_PRODUCT_IMAGE = "product_image";
//	private static final String KEY_PRODUCT_PRICE = "product_price";
//	private static final String KEY_PRODUCT_QUANTITY = "product_quantity";
//	private static final String KEY_PRODUCT_STOCK = "product_stock";
//	private static final String KEY_DISCOUNT_IN = "discount_in";
//	private static final String KEY_MAX_DISCOUNT = "max_discount";
//	private static final String KEY_SHIPPING = "product_shipping";
//	private static final String KEY_COUPON = "product_coupon";
//	private static final String KEY_TAX = "product_tax";
//	private static final String KEY_COUNTER = "counter";
//	private static final String KEY_DATA = "data";
//	private static final String KEY_OPTION = "option";
//	private static final String KEY_CURRENCY_SM = "currency_sm";
//	private static final String KEY_RATING = "rating_av";
//	private static final String KEY_IS_LIVE = "is_live";
//
//
//
///////////// Database tables  ////////////
//
//	private String DATABASE_TABLE_CART = "cart_table";
//	private String DATABASE_TABLE_SAVED = "saved_table";
//	private String DATABASE_TABLE_RECENTLY_VIEWED = "recently_viewed_table";
//	private String DATABASE_TABLE_REMOVE_CART_ITEM = "remove_cart_item_table";
//	private String DATABASE_TABLE_SEARCH_PRODUCT = "products";
//	private String DATABASE_TABLE_HOME_DATA = "home";
//	private String DATABASE_TABLE_CATEGORIES_DATA = "categories_table";
//
//
//	public DbManager(Context context) {
//		super(context, DATABASE_NAME, null, DATABASE_VERSION);
//	}
//
//	@Override
//	public void onCreate(SQLiteDatabase db) {
//		String CREATE_ADD_TO_CART_TABLE = "CREATE TABLE " + DATABASE_TABLE_CART + "("
//                + KEY_COUNTER + " integer primary key autoincrement ,"
//				+ KEY_PRODUCT_ID + " TEXT,"
//				+ KEY_PRODUCT_QUANTITY + " TEXT,"
//				+ KEY_OPTION + " TEXT,"
//		        +KEY_DATA + " TEXT )";
//
//		db.execSQL(CREATE_ADD_TO_CART_TABLE);
//
//		String CREATE_HOME_DATA_TABLE = "CREATE TABLE " + DATABASE_TABLE_HOME_DATA + "("+ KEY_DATA + " TEXT )";
//
//		db.execSQL(CREATE_HOME_DATA_TABLE);
//
//
//		String CREATE_CATEGORIES_DATA_TABLE = "CREATE TABLE " + DATABASE_TABLE_CATEGORIES_DATA + "("+ KEY_DATA + " TEXT )";
//
//		db.execSQL(CREATE_CATEGORIES_DATA_TABLE);
//
//
//		String CREATE_SAVED_TABLE = "CREATE TABLE " + DATABASE_TABLE_SAVED + "("
//				+ KEY_PRODUCT_ID + " TEXT ,"
//				+ KEY_PRODUCT_NAME + " TEXT ,"
//				+ KEY_PRODUCT_PRICE + " TEXT ,"
//				+ KEY_PRODUCT_IMAGE + " TEXT ,"
//				+ KEY_IS_LIVE + " TEXT )";
//
//		db.execSQL(CREATE_SAVED_TABLE);
////
//		String CREATE_RECENTLY_VIEWED_TABLE = "CREATE TABLE " + DATABASE_TABLE_RECENTLY_VIEWED + "("
//				+ KEY_PRODUCT_PRICE + " TEXT ,"
//				+ KEY_PRODUCT_IMAGE + " TEXT ,"
//				+ KEY_COUNTER + " integer primary key autoincrement ,"
//				+ KEY_DISCOUNT_IN + " TEXT ,"
//				+ KEY_MAX_DISCOUNT + " TEXT ,"
//				+ KEY_CURRENCY_SM + " TEXT ,"
//				+ KEY_RATING + " TEXT ,"
//				+ KEY_PRODUCT_NAME + " TEXT ,"
//				+ KEY_PRODUCT_ID + " TEXT )";
//
//		db.execSQL(CREATE_RECENTLY_VIEWED_TABLE);
////
////		String CREATE_REMOVE_CART_ITEM_TABLE = "CREATE TABLE " + DATABASE_TABLE_REMOVE_CART_ITEM + "("
////				+ KEY_PRODUCT_ID + " TEXT )";
////
////		db.execSQL(CREATE_REMOVE_CART_ITEM_TABLE);
////
////
////		String CREATE_SEARCH_PRODUCT_TABLE = "CREATE TABLE " + DATABASE_TABLE_SEARCH_PRODUCT + "("
////				+ KEY_PRODUCT_ID + " TEXT ,"
////				+ KEY_PRODUCT_NAME + " TEXT )";
////
////		db.execSQL(CREATE_SEARCH_PRODUCT_TABLE);
//
//	}
//
//	@Override
//	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_CART);
//		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_SAVED);
//		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_RECENTLY_VIEWED);
//		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_CATEGORIES_DATA);
//		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_HOME_DATA);
//		onCreate(db);
//
//	}
//
//	///////////////// Saved Viewed  /////////////////////////
//
//	public void insertSavedItem(String productId,String productName,String price,String productImage,
//										 String isLive){
//		SQLiteDatabase db = this.getWritableDatabase();
//		ContentValues contentValues=new ContentValues();
//		contentValues.put(KEY_PRODUCT_ID,productId);
//		contentValues.put(KEY_PRODUCT_NAME,productName);
//		contentValues.put(KEY_PRODUCT_PRICE,price);
//		contentValues.put(KEY_PRODUCT_IMAGE,productImage);
//		contentValues.put(KEY_IS_LIVE,isLive);
//
//		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_SAVED+ " where " + KEY_PRODUCT_ID + " = ? ";
//
//		@SuppressLint("Recycle") Cursor cursor = db.rawQuery(selectQuery, new String[]{productId});
//		if(cursor.getCount()==0){
//			db.insert(DATABASE_TABLE_SAVED,null,contentValues);
//		}else {
//			if(isLive.equalsIgnoreCase("1")) {
//				db.update(DATABASE_TABLE_SAVED, contentValues, KEY_PRODUCT_ID + "=?", new String[]{productId});
//			}
//		}
//
//	}
//
//	public List<HomeProductDataModel> getWished() {
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		List<HomeProductDataModel> list=new ArrayList<>();
//
//		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_SAVED;
//
//		@SuppressLint("Recycle") Cursor cursor = db.rawQuery(selectQuery,null);
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				HomeProductDataModel model=new HomeProductDataModel();
//				model.setProductId(cursor.getString(0));
//				model.setTitle(cursor.getString(1));
//				model.setSalePrice(cursor.getString(2));
//				model.setImge(cursor.getString(3));
//				model.setIsLive(cursor.getString(4));
//
//				list.add(0,model);
//			} while (cursor.moveToNext());
//		}
//		db.close();
//		return list;
//	}
//
//	public void deleteWishedItem(String productId){
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		db.delete(DATABASE_TABLE_SAVED, KEY_PRODUCT_ID + " = ? ",
//				new String[] {productId});
//		db.close();
//	}
//
//
//	///////////////// Recently Viewed  /////////////////////////
//
//	public void insertRecentlyViewedItem(String productId,String imageName,String price,String discountIn,
//										 String discountMax,String currSm,String ratingAv,String productName){
//		SQLiteDatabase db = this.getWritableDatabase();
//		ContentValues contentValues=new ContentValues();
//		contentValues.put(KEY_PRODUCT_PRICE,price);
//		contentValues.put(KEY_PRODUCT_IMAGE,imageName);
//		contentValues.put(KEY_DISCOUNT_IN,discountIn);
//		contentValues.put(KEY_MAX_DISCOUNT,discountMax);
//		contentValues.put(KEY_CURRENCY_SM,currSm);
//		contentValues.put(KEY_RATING,ratingAv);
//		contentValues.put(KEY_PRODUCT_NAME,productName);
//		contentValues.put(KEY_PRODUCT_ID,productId);
//
//
//		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_RECENTLY_VIEWED + " where " + KEY_PRODUCT_ID + " = ? ";
//
//		Cursor cursor = db.rawQuery(selectQuery, new String[]{productId});
//		if(cursor.getCount()==0){
//			db.insert(DATABASE_TABLE_RECENTLY_VIEWED,null,contentValues);
//		}
//
//	}
//
//
//	public List<RecentViewedModel> getRecentlyViewed(int minCount,int maxCount) {
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		String productIds="";
//		List<RecentViewedModel> list=new ArrayList<>();
//
//		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_RECENTLY_VIEWED + " where " + KEY_COUNTER + " >= ?";
//
//
//		Cursor cursor = db.rawQuery(selectQuery, new String[]{minCount+""});
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				RecentViewedModel model=new RecentViewedModel(cursor.getString(8),cursor.getString(1),
//						cursor.getString(0),cursor.getString(3),cursor.getString(4),cursor.getString(5),
//						cursor.getString(6),cursor.getString(7));
//				//productIds=productIds+cursor.getString(5)+",";
//				list.add(model);
//			} while (cursor.moveToNext());
//			//productIds=productIds.substring(0,productIds.length()-1);
//		}
//		db.close();
//		return list;
//
//	}
//	public List<HomeProductDataModel> getRecentlyViewedTopTen() {
//
//		List<HomeProductDataModel> list=new ArrayList<>();
//
////		SQLiteDatabase db = this.getWritableDatabase();
////		String productIds="";
////
////		Cursor cursor = db.query(DATABASE_TABLE_RECENTLY_VIEWED,null,null,null,null,null,KEY_COUNTER+" desc ","10");
////
////		if (cursor.moveToFirst()) {
////			do {
////				//productIds=productIds+cursor.getString(5)+",";
////				HomeProductDataModel model=new HomeProductDataModel();
////				model.setSalePrice(cursor.getString(0));
////				model.setImge(cursor.getString(1));
////				model.setDiscount(cursor.getString(3));
////				model.setDiscounttype(cursor.getString(4));
////				model.setProductId(cursor.getString(5));
////
////				list.add(model);
////			} while (cursor.moveToNext());
////		}
////		db.close();
//		return list;
//
//	}
//
//
//	/////   Cart  /////
//	public void insertRemovedCartItem(String productId){
//		SQLiteDatabase db = this.getWritableDatabase();
//		ContentValues contentValues=new ContentValues();
//		contentValues.put(KEY_PRODUCT_ID,productId);
//
//		db.insert(DATABASE_TABLE_REMOVE_CART_ITEM,null,contentValues);
//
//	}
//
//
//	// Categories table
//	public void insertCategoriesData(String json){
//		deleteCategoriesData();
//		SQLiteDatabase db = this.getWritableDatabase();
//		ContentValues contentValues=new ContentValues();
//		contentValues.put(KEY_DATA,json);
//
//		db.insert(DATABASE_TABLE_CATEGORIES_DATA,null,contentValues);
//
//	}
//
//	public AllCategoryResponseModel getCategoriesData() {
//
//		SQLiteDatabase db = this.getWritableDatabase();
//
//
//		String catData="";
//		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_CATEGORIES_DATA ;
//
//		Cursor cursor = db.rawQuery(selectQuery,null);
//
//		if(cursor.getCount()>0) {
//			if (cursor.moveToFirst()) {
//				do {
//
//					catData = cursor.getString(0);
//
//				} while (cursor.moveToNext());
//			}
//		}
//		db.close();
//		Gson gson = new Gson();
//
//		if(catData.equals("")){
//			return null;
//		}
//		else {
//			AllCategoryResponseModel obj = gson.fromJson(catData, AllCategoryResponseModel.class);
//			return obj;
//		}
//	}
//
//	public void deleteCategoriesData(){
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		db.delete(DATABASE_TABLE_CATEGORIES_DATA,null, null);
//		db.close();
//	}
//	// home table
//	public void insertHomeData(String json){
//		deleteHomeData();
//		SQLiteDatabase db = this.getWritableDatabase();
//		ContentValues contentValues=new ContentValues();
//		contentValues.put(KEY_DATA,json);
//
//		db.insert(DATABASE_TABLE_HOME_DATA,null,contentValues);
//
//	}
//
//	public HomeResponseModel getHomeData() {
//
//		SQLiteDatabase db = this.getWritableDatabase();
//
//
//		String homeData="";
//		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_HOME_DATA ;
//
//		Cursor cursor = db.rawQuery(selectQuery,null);
//
//		if(cursor.getCount()>0) {
//			if (cursor.moveToFirst()) {
//				do {
//
//					homeData = cursor.getString(0);
//
//				} while (cursor.moveToNext());
//			}
//		}
//		db.close();
//		Gson gson = new Gson();
//
//		if(homeData.equals("")){
//			return null;
//		}
//		else {
//			HomeResponseModel obj = gson.fromJson(homeData, HomeResponseModel.class);
//			return obj;
//		}
//	}
//
//	public void deleteHomeData(){
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		db.delete(DATABASE_TABLE_HOME_DATA,null, null);
//		db.close();
//	}
//
//	public String getRemovedCartItemsData() {
//
//		SQLiteDatabase db = this.getWritableDatabase();
//
//
//		String productIds="";
//		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_REMOVE_CART_ITEM ;
//
//		Cursor cursor = db.rawQuery(selectQuery,null);
//
//		if (cursor.moveToFirst()) {
//			do {
//
//				productIds=productIds+cursor.getString(0)+",";
//
//			} while (cursor.moveToNext());
//		}
//		db.close();
//		return productIds;
//
//	}
//
//	public boolean insertAddToCartItem(String productId,String qty,int stock,String data,String options) {
//		SQLiteDatabase db = this.getWritableDatabase();
//		boolean flag=true;
//		int finalQty;
//		ContentValues contentValues=new ContentValues();
//		contentValues.put(KEY_PRODUCT_ID,productId);
//		contentValues.put(KEY_OPTION,options);
//		contentValues.put(KEY_DATA,data);
//
//		String selectQuery = "SELECT  "+KEY_PRODUCT_QUANTITY+" FROM " + DATABASE_TABLE_CART + " where " + KEY_PRODUCT_ID + " = ? and "
//                + KEY_OPTION + " = ? ";
//
//		Cursor cursor = db.rawQuery(selectQuery, new String[]{productId,options});
//		if(cursor.getCount()>0){
//			if(cursor.moveToFirst()){
//				String oldQty=cursor.getString(0);
//				finalQty=Integer.parseInt(oldQty)+Integer.parseInt(qty);
//				if(stock<finalQty){
//					flag=false;
//				}
//				else {
//					contentValues.put(KEY_PRODUCT_QUANTITY,finalQty+"");
//					db.update(DATABASE_TABLE_CART, contentValues,KEY_PRODUCT_ID+"=? and "+KEY_OPTION+"=?", new String[]{productId,options});
//					flag=true;
//				}
//
//			}
//
//		}
//		else {
//
//			contentValues.put(KEY_PRODUCT_QUANTITY,qty);
//			db.insert(DATABASE_TABLE_CART,null,contentValues);
//			flag=true;
//		}
//		return flag;
//	}
//
//
//	public boolean updateCartItemQuantity(String productId,int productQuantity) {
//		SQLiteDatabase db = this.getWritableDatabase();
//		long l=0;
//		ContentValues contentValues=new ContentValues();
//		contentValues.put(KEY_PRODUCT_ID,productId);
//
//		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_CART + " where " + KEY_PRODUCT_ID + " = ? ";
//
//		Cursor cursor = db.rawQuery(selectQuery, new String[]{productId});
//		if(cursor.getCount()>0){
//			if(cursor.moveToFirst()){
//
//				contentValues.put(KEY_PRODUCT_QUANTITY,productQuantity+"");
//				db.update(DATABASE_TABLE_CART, contentValues,KEY_PRODUCT_ID+"="+productId, null);
//			}
//
//		}
//
//		if(l==0){
//			return false;
//		}
//		db.close();
//		return  true;
//	}
//
//
//
//	public void deleteAddToCartItems(){
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		db.delete(DATABASE_TABLE_CART,null, null);
//		db.close();
//	}
//
//	public void deleteRecentViewedItems(){
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		db.delete(DATABASE_TABLE_RECENTLY_VIEWED,null, null);
//		db.close();
//	}
//
//
//
//	public void deleteCartSingleItem(String productId,String options){
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		db.delete(DATABASE_TABLE_CART, KEY_PRODUCT_ID + " =? and "+KEY_OPTION+"=?",
//				new String[] {productId,options});
//		db.close();
//	}
//
//
//
//	/////  Get one to one messages from database  /////
//
////
////	/////  Get group messages from database  /////
////
////	public List<ChatMessageDetailBean> getAllGroupChatMessages(String my_id, String sender_id) {
////
////		SQLiteDatabase db = this.getWritableDatabase();
////		List<ChatMessageDetailBean> DataModel_list = new ArrayList<ChatMessageDetailBean>();
////		// Select All Query
////		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_GROUP_MESSAGES + " where " + KEY_GROUP_ID + " = ? ";
////
////		Cursor cursor = db.rawQuery(selectQuery, new String[]{sender_id});
////
////		// looping through all rows and adding to list
////		if (cursor.moveToFirst()) {
////			do {
////				ChatMessageDetailBean mDataModel = new ChatMessageDetailBean(cursor.getString(2),cursor.getString(0)
////						,cursor.getString(5),cursor.getString(4),cursor.getString(6),cursor.getString(3)
////						,cursor.getString(1));
////
////				DataModel_list.add(mDataModel);
////			} while (cursor.moveToNext());
////		}
////		db.close();
////
////		return DataModel_list;
////
////	}
//
//	/////  Get chat members messages from database  /////
//
//	public List<CartModel> getDbCartData() {
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		Gson gson=new Gson();
//
//		List<CartModel> cartModels=new ArrayList<>();
//
//		String data=null;
//
//		// Select All Query
//		String selectQuery = "SELECT  "+KEY_PRODUCT_QUANTITY+","+KEY_DATA+" FROM " + DATABASE_TABLE_CART ;
//
//		Cursor cursor = db.rawQuery(selectQuery,null);
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				CartModel cartModel=gson.fromJson(cursor.getString(1),CartModel.class);
//				if(!cartModel.getCurrencyCode().equalsIgnoreCase(Keys.SELECTED_CURRENCY_CODE)){
//					cartModel.setPrice(Double.parseDouble(cartModel.getPrice())*Keys.SELECTED_CURRENCY_RATE_DEF+"");
//					cartModel.setShipping(Double.parseDouble(cartModel.getShipping())*Keys.SELECTED_CURRENCY_RATE_DEF+"");
//					cartModel.setDiscount(Double.parseDouble(cartModel.getDiscount())*Keys.SELECTED_CURRENCY_RATE_DEF+"");
//				}
//				String qty=cursor.getString(0);
//				cartModel.setQty(qty);
//				cartModels.add(cartModel);
//
//			} while (cursor.moveToNext());
//		}
//		db.close();
//		return cartModels;
//
//	}
////
//	public int getDbCartCount() {
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		int count;
//		// Select All Query
//		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_CART ;
//
//		Cursor cursor = db.rawQuery(selectQuery,null);
//		count=cursor.getCount();
//		if(count==0) {
//			count=0;
//		//	AppConstants.cartTab.setBadgeCount(count);
//		}
//
//		db.close();
//		return count;
//
//	}
////
////	public int insertSearchData(String query){
////
////		int count;
////		SQLiteDatabase db = this.getWritableDatabase();
////
////		db.delete(DATABASE_TABLE_SEARCH_PRODUCT,null, null);
////		db.execSQL(query);
////
////		String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_SEARCH_PRODUCT ;
////
////		Cursor cursor = db.rawQuery(selectQuery,null);
////		count=cursor.getCount();
////		if(count==0) {
////			count=0;
////		}
////		return count;
////	}
////	public List<SearchDataModel> getSearchData(String word){
////
////		SQLiteDatabase db = this.getWritableDatabase();
////		List<SearchDataModel> searchDataModels=new ArrayList<>();
////
////		if(!word.equals("")) {
////			Cursor cursor = db.query(true, DATABASE_TABLE_SEARCH_PRODUCT, new String[]{KEY_PRODUCT_ID, KEY_PRODUCT_NAME}, KEY_PRODUCT_NAME + " LIKE ?",
////					new String[]{"%" + word + "%"}, null, null, null,
////					null);
////
////			if (cursor.moveToFirst()) {
////				do {
////					SearchDataModel searchDataModel = new SearchDataModel(cursor.getString(0), cursor.getString(1));
////					searchDataModels.add(searchDataModel);
////				} while (cursor.moveToNext());
////			}
////		}
////		db.close();
////
////		return searchDataModels;
////	}
//
//
//
//
//
//	/////  url conversion to byte array (blob) //////
//
////    public static byte[] urlToImageBLOB(String url) throws IOException {
////        HttpResponse response;
////        DefaultHttpClient httpclient; httpclient = new DefaultHttpClient();
////        HttpEntity entity = null;
////        HttpUriRequest httpGet = new HttpGet(url);
////        response = httpclient.execute(httpGet);
////        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
////            entity = response.getEntity();
////        }
////        return EntityUtils.toByteArray(entity);
////    }
////    public static Bitmap getImageFromBLOB(byte[] mBlob) {
////        byte[] bb = mBlob;
////        return BitmapFactory.decodeByteArray(bb, 0, bb.length);
////    }
//}