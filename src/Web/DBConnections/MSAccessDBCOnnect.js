var adoConn = new ActiveXObject("ADODB.Connection");
adoConn.Open("Provider=Microsoft.Jet.OLEDB.4.0;Data Source='/\dbName.mdb'");


//Adding a Record
function AddRecord() {
    var adoRS = new ActiveXObject("ADODB.Recordset");

    adoRS.Open("Select * From tblName", adoConn, 1, 3);

    adoRS.AddNew;
    adoRS.Fields("FieldName").value = "Quentin";
    adoRS.Update;


}

//Removing a Record
function DeleteRecord() {
    var adoConn = new ActiveXObject("ADODB.Connection");
    var adoRS = new ActiveXObject("ADODB.Recordset");

    adoConn.Open("Provider=Microsoft.Jet.OLEDB.4.0;Data Source='\\dbName.mdb'");
    adoRS.Open("Select * From tblName Where FieldName = 'Quentin'", adoConn, 1, 3);
    adoRS.Delete;
    adoRS.Delete;

    adoRS.Close();
    adoConn.Close();
}

//Editing a Record
function EditRecord() {
    var adoConn = new ActiveXObject("ADODB.Connection");
    var adoRS = new ActiveXObject("ADODB.Recordset");

    adoConn.Open("Provider=Microsoft.Jet.OLEDB.4.0;Data Source='\\dbName.mdb'");
    adoRS.Open("Select * From tblName Where FieldName = 'Quentin'", adoConn, 1, 3);

    adoRS.Edit;
    adoRS.Fields("FieldName").value = "New Name";
    adoRS.Update;

    adoRS.Close();
    adoConn.Close();
}

adoRS.Close();
adoConn.Close();