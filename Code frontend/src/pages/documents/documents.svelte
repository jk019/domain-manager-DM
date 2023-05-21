<script>
  import axios from "axios";

  let documents = [];

  function getdocuments() {
    axios.get("http://localhost:8080/document/all").then((response) => {
      documents = response.data;
      console.log(response.data);
    });
  }
  getdocuments();
</script>

<div class="mb-5">
  <h1 class="mt-3">Liste aller documents</h1>

  <a href="#/create-document"
  ><button class="btn btn-warning" type="button">
    <i class="fas fa-plus" /> document hinzufügen
  </button></a
>

  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Creation_Date</th>
        <th>Domain</th>
        <th>Element ID</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      {#each documents as document}
        <tr>
          <td>
            {document.id}
          </td>
          <td>
            {document.creation_date}
          </td>
          <td>
            <a href={"#/domains/edit/" + document.domain.id}> {document.domain.name}</a>
          </td>
          <td>
            {document.element.id}
          </td>
          <td>
           
          </td>
        </tr>
      {/each}
    </tbody>
  </table>
</div>
