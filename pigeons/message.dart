import 'package:pigeon/pigeon_lib.dart';

class ViaAesRequest {
  String data;
  String key;
  String iv;
}

class ViaAesReply {
  String result;
}

@HostApi()
abstract class ViaAesApi {
  ViaAesReply encrypt(ViaAesRequest request);
  ViaAesReply decrypt(ViaAesRequest request);

}