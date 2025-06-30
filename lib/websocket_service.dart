import 'dart:convert';
import 'package:web_socket_channel/web_socket_channel.dart';

/*class WebSocketService {
  // Singleton pattern
  static final WebSocketService _singleton = WebSocketService._internal();
  late final WebSocketChannel _channel;

  /// Callback pentru a transmite acțiunea și ID-ul unui obiect
  Function(String action, int id)? onMessageReceived;

  factory WebSocketService() {
    return _singleton;
  }

  WebSocketService._internal() {
    // Inițializare canal WebSocket
    _channel = WebSocketChannel.connect(
      Uri.parse('ws://localhost:8080/ws/notifications'), // <- adresa WebSocket server
    );

    // Ascultare pentru mesaje primite
    _channel.stream.listen(
          (dynamic message) {
        try {
          final decoded = jsonDecode(message as String);

          if (decoded is Map<String, dynamic>) {
            final action = decoded['action'];
            final id = decoded['id'];

            if (action is String && id is int) {
              onMessageReceived?.call(action, id);
            } else {
              print('Format invalid în mesaj WebSocket: $decoded');
            }
          } else {
            print('Mesajul primit nu este de tip Map: $decoded');
          }
        } catch (e) {
          print('Eroare la decodarea mesajului WebSocket: $e');
        }
      },
      onError: (error) {
        print('Eroare pe canalul WebSocket: $error');
      },
      onDone: () {
        print('Conexiunea WebSocket a fost închisă.');
      },
    );
  }

  /// Închide conexiunea WebSocket
  void dispose() {
    _channel.sink.close();
  }

  /// Trimitere mesaj (opțional)
  void sendMessage(String message) {
    _channel.sink.add(message);
  }
}*/

class WebSocketService {
  static final WebSocketService _singleton = WebSocketService._internal();
  late final WebSocketChannel _channel;

  Function(String action, int id)? onMessageReceived;

  factory WebSocketService() => _singleton;

  WebSocketService._internal() {
    print('Connecting to WebSocket server at ws://localhost:8080/ws/notifications');
    _channel = WebSocketChannel.connect(
      Uri.parse('ws://localhost:8080/ws/notifications'),
    );

    _channel.stream.listen(
          (dynamic message) {
        print('Received WebSocket message: $message');
        try {
          final decoded = jsonDecode(message as String);
          if (decoded is Map<String, dynamic>) {
            final action = decoded['action'];
            final id = decoded['id'];
            if (action is String && id is int) {
              onMessageReceived?.call(action, id);
            } else {
              print('Invalid message format: $decoded');
            }
          } else {
            print('Message is not a Map: $decoded');
          }
        } catch (e) {
          print('Error decoding WebSocket message: $e');
        }
      },
      onError: (error) => print('WebSocket error: $error'),
      onDone: () => print('WebSocket connection closed.'),
    );
  }

  void dispose() {
    _channel.sink.close();
  }

  void sendMessage(String message) {
    _channel.sink.add(message);
  }
}
