package com.via.viapigeon;

import android.os.Bundle;

import com.via.viapigeon.utils.AESUtils;

import io.flutter.app.FlutterActivity;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {

  private class MyApi implements Pigeon.ViaAesApi {
    @Override
    public Pigeon.ViaAesReply encrypt(Pigeon.ViaAesRequest arg) {
      String iv = arg.getIv();
      String data = arg.getData();
      String key = arg.getKey();
      Pigeon.ViaAesReply reply = new Pigeon.ViaAesReply();
      System.out.print("**********data**********"+data);
      System.out.print("***********key*********"+key);
      try {
        reply.setResult(AESUtils.encrypt(data,key));
      } catch (Exception e) {
        System.out.print("********************"+e.getMessage());
        e.printStackTrace();
      }
      return reply;
    }

    @Override
    public Pigeon.ViaAesReply decrypt(Pigeon.ViaAesRequest arg) {
      String iv = arg.getIv();
      String data = arg.getData();
      String key = arg.getKey();
      Pigeon.ViaAesReply reply = new Pigeon.ViaAesReply();
      reply.setResult(AESUtils.decrypt(data,key));
      return reply;
    }
//    @Override
//    public Pigeon.SearchReply search(Pigeon.SearchRequest request) {
//      Pigeon.SearchReply reply = new Pigeon.SearchReply();
//      reply.setResult(String.format("Hi %s!", request.getQuery()));
//      return reply;
//    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);
    Pigeon.ViaAesApi.setup(getFlutterView(), new MyApi());
  }
}
