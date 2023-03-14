import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';
import 'package:uncwnavigatorapplication/models/site_model.dart';
import 'package:uncwnavigatorapplication/widgets/site_of_interest.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class SiteList extends StatefulWidget {
  SiteList({super.key});

  @override
  State<SiteList> createState() => _SiteListState();
}

class _SiteListState extends State<SiteList> {
  final siteRef = FirebaseFirestore.instance.collection('site');

  List<QueryDocumentSnapshot<Map<String, dynamic>>> searchResults = [];

  List<String> hints = [];

  var indexList = [];
  var index = 0;

  final TextEditingController _controller = TextEditingController();

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getPresetInfo();
  }

  _getPresetInfo() {
    siteRef.get().then(
      (result) {
        searchResults = result.docs;
        setState(() {});
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return StreamBuilder(
      stream: siteRef.snapshots(),
      builder: (context, snapshot) {
        if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
          return Text("No Data to Show!");
        }

        // extra
        if (snapshot.hasError) {
          // if the network is unreachable, or if firestore throws an acess exception
        }

        var siteDocs = snapshot.data!.docs;

        return Scaffold(
            // floatingActionButton: FloatingActionButton(onPressed: () => print("object"),),
            backgroundColor: AppColors.primary,
            body: Column(
              children: [
                Padding(
                  padding: EdgeInsets.fromLTRB(16, 0, 16, 0),
                  child: TextField(
                    controller: _controller,
                    cursorColor: AppColors.primaryAccent,
                    decoration: InputDecoration(
                        enabledBorder: UnderlineInputBorder(
                          borderSide:
                              BorderSide(color: AppColors.primaryAccent),
                        ),
                        focusedBorder: UnderlineInputBorder(
                          borderSide:
                              BorderSide(color: AppColors.primaryAccent),
                        ),
                        border: UnderlineInputBorder(
                          borderSide:
                              BorderSide(color: AppColors.primaryAccent),
                        ),
                        hintText: "Enter a Site Of Interest: Case Sensitive"),
                    onChanged: (value) {

                      if (value == '') {
                        siteRef.get().then(
                          (result) {
                            searchResults = result.docs;
                            index = 0;
                            indexList = [];
                            setState(() {});
                          },
                        );
                      } else {
                        siteRef
                            .where('siteName',
                                isGreaterThanOrEqualTo: value,
                                isLessThan: value + 'z')
                            .get()
                            .then((result) {
                          searchResults = result.docs;
                          index = 0;
                          indexList = [];

                          for (var item in siteDocs) {
                            // track this for spot in list for later 0, 1, 2, 3, 4, 5, 6
                            for (var item2 in searchResults) {
                              if (item.get('siteName') ==
                                  item2.get('siteName')) {
                                indexList.add(index);
                              }
                            }
                            index = index + 1;
                            // if (searchResults.contains(item)) {
                            //   indexList.add(index);
                            //   print(indexList);
                            //   print(index);
                            //   index = index +1;
                            // } else {
                            //   index = index + 1;
                            //   print("bad");
                            // }
                          }
                          setState(() {});
                        });
                      }
                    },
                  ),
                ),
                Expanded(
                    child: ListView.builder(
                  addAutomaticKeepAlives: true,
                  itemCount: (searchResults.length),
                  itemBuilder: (context, index) {
                    if (indexList.isEmpty) {
                      return MyCardForDisplay(siteDocs[index]);
                    } else {
                      return MyCardForDisplay(siteDocs[indexList[index]]);
                    }

                    // for (var element in siteDocs) {
                    //   if (searchResults.contains(element)){
                    //     return MyCardForDisplay();
                    //   }
                    // }
                    // // for (var element in searchResults) {
                    // //   if (element.id == siteDocs[index].id) {
                    // //     print('${element.id}, ${siteDocs[index].id}');
                    // //     return MyCardForDisplay(siteDocs[index]);
                    // //   }
                    // // }
                    // return MyCardForDisplay(searchResults[index]);
                  },
                )),
              ],
            )

            // GridView.builder(
            //   addAutomaticKeepAlives: true,
            //   itemCount: siteDocs.length,
            //   gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
            //       crossAxisCount: 1, childAspectRatio: 5),
            //   itemBuilder: (context, index) {
            //     // might change this to list tiles not cards
            //     return MyCardForDisplay(siteDocs[index]);
            //   },
            // ),
            );
      },
    );
  }
}
