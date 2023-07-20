mock "GET /api/v2/facts/random" {
  status = 200
  
  headers {
    Content-Type = "application/json"
  }

  body = <<EOF
    {
      "id": "13ce4f95fce6e6f0220c803c24cd2dfd",
      "text": "The \"save\" icon on Microsoft Word shows a floppy disk with the shutter on backwards.",
      "source": "djtech.net",
      "source_url": "http://www.djtech.net/humor/useless_facts.htm",
      "language": "en",
      "permalink": "https://uselessfacts.jsph.pl/api/v2/facts/13ce4f95fce6e6f0220c803c24cd2dfd"
    }  
  EOF

}
