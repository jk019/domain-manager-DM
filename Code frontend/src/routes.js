// Pages
import Home from "./pages/Home.svelte";

import Elements from "./pages/elements/Elements.svelte";

import Complex from "./pages/elements/Complex/Complex.svelte";
import EditComplex from "./pages/elements/Complex/EditComplex.svelte";
import CreateComplex from "./pages/elements/Complex/CreateComplex.svelte";

import Simple from "./pages/elements/Simple/Simple.svelte";
import EditSimple from "./pages/elements/Simple/EditSimple.svelte";
import CreateSimple from "./pages/elements/Simple/CreateSimple.svelte";

import Documents from "./pages/documents/documents.svelte";
import CreateDocument from "./pages/documents/CreateDocument.svelte";
import EditDocument from "./pages/documents/EditDocument.svelte";

import Domains from "./pages/domains/Domains.svelte";
import CreateDomain from "./pages/domains/CreateDomain.svelte";
import EditDomain from "./pages/domains/editDomains.svelte";


export default {
  // Home
  "/": Home,
  "/home": Home,

  //Elements
  "/elements": Elements,

  //Complex
  "/complex": Complex,
  "/complex/edit/:id": EditComplex,
  "/create-complex": CreateComplex,

  //Simple
  "/simple": Simple,
  "/simple/edit/:id": EditSimple,
  "/create-simple": CreateSimple,

  //Documents
  '/documents': Documents,
  "/document/edit/:id": EditDocument,
  "/create-document": CreateDocument,

  //Domains
  '/domains': Domains,
  "/create-domain": CreateDomain,
  "/domains/edit/:id": EditDomain,

};
