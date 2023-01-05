import 'dart:math';

import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:geolocator/geolocator.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:location/location.dart';

class MapScreen extends StatefulWidget {
  MapScreen({super.key});

  @override
  State<MapScreen> createState() => _MapScreenState();
}

class _MapScreenState extends State<MapScreen> {
  GoogleMapController? _controller;
  Map<MarkerId, Marker> markers = <MarkerId, Marker>{};

  final siteRef = FirebaseFirestore.instance.collection('site');


  static const CameraPosition _uncwBellTower = CameraPosition(
    target: LatLng(34.2271592, -77.8729786),
    zoom: 15,
  );

  Future<Map<MarkerId, Marker>> siteValues() async {
    await FirebaseFirestore.instance.collection('site').get().then((value) {
      value.docs.forEach((element) { 
        MarkerId elementMarkerId = MarkerId(element.data()['siteName']);
        Marker elementMarker = Marker(
          markerId: elementMarkerId,
          infoWindow: InfoWindow(
            title: element.data()['siteName'],
            // snippet: Maybe Distance from user
            onTap: () {
            },
          ),
          position: LatLng(element.data()['lat'], element.data()['long']), // going to me lat and long
        );
        markers[elementMarkerId] = elementMarker;
      });
    });
    return markers;
  
  }

  @override
  Widget build(BuildContext context) {
          return 
          // maybe create a stream for turning the location on and off 
          // create problems for the markers when location enabled
          FutureBuilder(
            future: siteValues() ,
            builder: (context, snapshot) {
            return GoogleMap(
              myLocationButtonEnabled: false,
              myLocationEnabled: true,
              mapType: MapType.hybrid,
              initialCameraPosition: _uncwBellTower,
              onMapCreated: (GoogleMapController controller) {
                _controller = controller;
              },
              markers: markers.values.toSet(),
            );
          
          },);
          
        }
  }

