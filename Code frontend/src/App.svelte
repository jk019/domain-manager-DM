<script>
  import Router from "svelte-spa-router";
  import routes from "./routes";
</script>

<!-- This part is always displayed -->
<nav class="navbar navbar-expand-lg navbar-light navbar-custom" id="navbar">
  <nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="#/">
        <img
          src="images/Logo.png"
          alt="Logo"
          width="40"
          height="40"
          class="d-inline-block align-text-top"
        />
      </a>
    </div>
  </nav>
  <div class="container-fluid">
    <a class="navbar-brand" href="#/">Project X</a>
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarNavDropdown"
      aria-controls="navbarNavDropdown"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon" />
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#/domains">Domains</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#/documents">Documents</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#/elements">Elemente</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-3">
  <!-- Here we load the page depending on the current URL -->
  <Router {routes} />
</div>

<style>
  .navbar-custom {
    /* background-color: #5a3a82; /* Dunkelgrün */
    background-image: linear-gradient(90deg, purple 0%, #e2b007 100%);
  }
  .navbar-brand {
    color: white;
  }
  .nav-link {
    color: white;
  }
  #navbar {
    z-index: 10; /*schaut, dass Navbar im Vordergrund bleibt*/
    position: sticky;
    top: 0; /*Position am oberen Rand fixiert*/
  }
</style>
