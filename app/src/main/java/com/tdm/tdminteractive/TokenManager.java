package com.tdm.tdminteractive;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TokenManager {
//    static public final String key = "abd89b50-d760-4a97-bb24-0a44881fc04a";
//    static public String genToken(String userId, String userRole, long exp, JSONArray userData, Context context) {
//        String token = "";
//        Map<String, Object> payloadClaims = new HashMap<>();
//        payloadClaims.put("id", userId);
//        payloadClaims.put("exp", exp);
//        payloadClaims.put("role", userRole);
//
//        payloadClaims.put("appId", "default-app");
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(key);
//
//            JWTCreator.Builder builder = JWT.create();
//
//            Map<String, Object> payloadUserData = new HashMap<>();
//            for(int i=0; i<userData.length(); i++) {
//                JSONObject itemField = userData.getJSONObject(i);
//                String keyField = "id";
////                itemField.put()
//                if(keyField.length() > 0) {
//                    switch (itemField.getString(Constant.typeField)) {
//                        case Constant.string:
//                            String valueField = itemField.getString(Constant.valueField);
//                            if(valueField.length() > 0) {
//                                payloadUserData.put("id", itemField.getString(Constant.valueField));
//                            }
//                            break;
//                        case Constant.number:
//                            payloadUserData.put("id", itemField.getInt(Constant.valueField));
//                            break;
//                        case Constant.bool:
//                            payloadUserData.put("id", itemField.getBoolean(Constant.valueField));
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            }
//            Log.d("payloadUserData=>", String.valueOf(payloadUserData.size()));
//            if(payloadUserData.size() > 0) {
//                payloadClaims.put(Constant.userDataField, payloadUserData);
////                SharePreferencesBase.getInstance(context).setValue(Constant.keyUserData, userData.toString());
//            } else {
////                SharePreferencesBase.getInstance(context).deleteKey(Constant.keyUserData);
//            }
//            token = builder.withPayload(payloadClaims).sign(algorithm);
//        } catch (JWTCreationException | JSONException exception){
//            //Invalid Signing configuration / Couldn't convert Claims.
//        }
//        Log.d("TokenGenerate=>", token);
////        setTokenCache(token, context);
//        return token;
//    }
//    static public void setTokenCache(String token, Context context) {
//        SharePreferencesBase.getInstance(context).setValue(Constant.keyAccessToken, token);
//    }
//    static public String getTokenCache(Context context) {
//        return SharePreferencesBase.getInstance(context).getAccessToken();
//    }
}