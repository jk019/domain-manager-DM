<script>
  import axios from "axios";

  let domains = [];

  function getDomains() {
    axios.get("http://localhost:8080/domains/all").then((response) => {
      domains = response.data;
      console.log(response.data);
    });
  }
  getDomains();
</script>

<div class="mb-5">
  <h1 class="mt-3">Liste aller Domains</h1>

  <a href="#/create-domain"
    ><button class="btn btn-warning" type="button">
      <i class="fas fa-plus" /> Domain hinzufügen
    </button></a
  >

  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>IP</th>
        <th />
      </tr>
    </thead>
    <tbody>
      {#each domains as domain}
        <tr>
          <td>
            {domain.id}
          </td>
          <td>
            <a href={"https://www."+domain.name}>{domain.name}</a>
          </td>
          <td>
            {domain.ip}
          </td>

          <td>
            <a href={"#/domains/edit/" + domain.id}
              ><button class="btn btn-warning" type="button">
                <i class="fas fa-edit" />
              </button>
            </a>
          </td>
        </tr>
      {/each}
    </tbody>
  </table>
</div>
