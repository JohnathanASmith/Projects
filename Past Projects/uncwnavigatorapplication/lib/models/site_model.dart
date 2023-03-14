class SiteOfInterest {
  const SiteOfInterest(
      {required this.favoritedBy,
      required this.siteName,
      required this.siteDescription,
      required this.siteImageReference,
      required this.lat,
      required this.long});

  final String siteName;
  final String siteDescription;
  final String siteImageReference;
  final List<String> favoritedBy;
  final double lat;
  final double long;

  Map<String, Object?> toMap() {
    // The { } create a Map object, much like { } in Python creates a dictionary
    // This method creates and immediately returns the map.
    return {
      'siteDescription': siteDescription,
      'siteImageReference': siteImageReference,
      'siteName': siteName,
      // 'visited': visited
      'favoritedBy': favoritedBy,
      'lat': lat,
      'long': long
    };
  }
}

class SitesData {
  final List<SiteOfInterest> sitesOfInterest = [
    const SiteOfInterest(
        favoritedBy: [""],
        siteName: "Randall Library",
        siteDescription:
            "Randall Library is named in honor of Dr. William Madison Randall, third president of Wilmington College (1958-68). President Randall developed the university seal and motto (discere aude - learn courageous). During his tenure, Wilmington College met requirements for accreditation as a four-year college. At his retirement in 1968, Dr. Randall was named president emeritus of Wilmington College.",
        siteImageReference: "Randall_Library",
        lat: 34.22787,
        long: -77.87419),
    const SiteOfInterest(
        favoritedBy: [""],
        siteName: "Bear Hall",
        siteDescription:
            "Bear Hall was named in recognition of the original Isaac Bear Building, located across the street from New Hanover High School in Wilmington, which served as the first home of Wilmington College from 1947-1961. Wilmington native Samuel Bear Jr. erected the original building as a memorial to his brother, Isaac Bear.",
        siteImageReference: "Bear_Hall",
        lat: 34.22872,
        long: -77.87277),
    const SiteOfInterest(
        favoritedBy: [""],
        siteName: "Alderman Hall",
        siteDescription:
            "Alderman Hall was one of the three original buildings on campus, along with James Hall and Hoggard Hall. The original function for this building, as administrative offices, is much the same as its current use. Alderman Hall is named for Edwin Anderson Alderman, a native of Wilmington, who served as president of the University of North Carolina (1890-1900), president of Tulane University (1900-1904), and president of the University of Virginia (1904-1931).",
        siteImageReference: "Alderman_Hall",
        lat: 34.22712,
        long: -77.87679),
    const SiteOfInterest(
        favoritedBy: [""],
        siteName: "Congdon Hall",
        siteDescription:
            "The building includes multi-disciplinary, hands-on laboratories equipped with the latest technologies; dynamically re-configurable research and educational spaces; student “sandboxes” to facilitate team-based collaborative learning; and a real-time financial trading room.",
        siteImageReference: "Congdon_Hall",
        lat: 34.22600,
        long: -77.87190),
    const SiteOfInterest(
        favoritedBy: [""],
        siteName: "Kenan Hall",
        siteDescription:
            "Kenan Hall is named in honor of Mrs. Sarah Graham Kenan, Wilmington philanthropist and benefactor of Wilmington College.",
        siteImageReference: "Kenan_Hall",
        lat: 34.22750,
        long: -77.87580),
    const SiteOfInterest(
        favoritedBy: [""],
        siteName: "Hanover Hall",
        siteDescription:
            "Hanover Hall is named in honor of all citizens of New Hanover County, who in 1946 voted to tax themselves for the establishment and support of Wilmington College. Hanover Hall served as the university basketball arena until Trask Coliseum was opened in 1977. The arena became the UNCW volleyball program’s home in 2001-02. The Hanover Hall weight room renovation in 2004 resulted in creation of the Seahawk Strength Center, a state-of-the-art strength and conditioning complex.",
        siteImageReference: "Hanover_Hall",
        lat: 34.22448,
        long: -77.87721),
  ];
}
