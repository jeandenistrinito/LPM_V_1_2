<%
    int number=Integer.parseInt(request.getParameter("val"));
    for(int i=1;i<=10;i++) {
        System.out.println(i*number);
    }
%>