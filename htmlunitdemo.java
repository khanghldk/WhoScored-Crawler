        try {
            
            WebClient client = new WebClient(BrowserVersion.BEST_SUPPORTED);
            String START_URL = "https://www.whoscored.com/";
            WebResponse page = client.loadWebResponse(new WebRequest(new java.net.URL(START_URL)));
            System.out.println(page.getStatusCode());
            client.getOptions().setThrowExceptionOnScriptError(false);

            client.getOptions().setJavaScriptEnabled(true);

            client.setJavaScriptTimeout(10000);
            client.getOptions().setTimeout(10000);
            client.waitForBackgroundJavaScript(30000);

            BufferedWriter writer = new BufferedWriter(new FileWriter("livescored.xml", false));

            List<HtmlAnchor> teams = (List) page.getByXPath("//a");

            for (HtmlAnchor link : teams) {
                System.out.println(link.asXml());
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }