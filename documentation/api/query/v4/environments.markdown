---
title: "PuppetDB 3.2 » API » v4 » Querying Environments"
layout: default
canonical: "/puppetdb/latest/api/query/v4/environments.html"
---

[curl]: ../curl.html#using-curl-from-localhost-non-sslhttp
[paging]: ./paging.html
[query]: ./query.html
[subqueries]: ./operators.html#subquery-operators
[factsets]: ./factsets.html
[reports]: ./reports.html
[catalogs]: ./catalogs.html
[facts]: ./facts.html
[fact-contents]: ./fact_contents.html
[events]: ./events.html
[resources]: ./resources.html

Environments are semi-isolated groups of nodes managed by Puppet. Nodes are assigned to environments by their own configuration, or by the puppet master's external node classifier.

When PuppetDB collects info about a node, it keeps track of the environment the node is assigned to. PuppetDB also keeps a list of environments it has seen. You can query this list by making an HTTP request to the `/environments` endpoint.

## `/pdb/query/v4/environments`

This will return all environments known to PuppetDB.

### URL Parameters

* `query`: Optional. A JSON array containing the query in prefix notation. If
  not provided, all results will be returned. See the sections below for the
  supported operators and fields. For general info about queries,
  see [the page on query structure.][query]

### Query Operators

See [the Operators page](./operators.html)

### Query Fields

* `"name"` (string): the name of an environment

### Subquery Relationships

Here is a list of related entities that can be used to constrain the result set using
implicit subqueries. For more information consult the documentation for [subqueries].

* [`factsets`][factsets]: Factsets received for an environment.
* [`reports`][reports]: Reports received for an environment.
* [`catalogs`][catalogs]: Catalogs received for an environment.
* [`facts`][facts]: Fact names and values received for an environment.
* [`fact_contents`][fact-contents]: Factset paths and values received for an environment.
* [`events`][events]: Report events triggered for an environment.
* [`resources`][resources]: Catalog resources received for an environment.

### Response format

The response is a JSON array of hashes, where each hash has the form:

    {"name": <string>}

The array is unsorted.

### Example

[You can use `curl`][curl] to query information about nodes like so:

    curl 'http://localhost:8080/pdb/query/v4/environments'

## `/pdb/query/v4/environments/<ENVIRONMENT>`

This will return the name of the environment if it currently exists in PuppetDB.

### URL Parameters / Query Operators / Query Fields

This route supports the same URL parameters and query fields/operators
as the '/pdb/query/v4/environments' route above.

### Response format

The response is a JSON hash of the form:

    {"name": <string>}

### Examples

[You can use `curl`][curl] to query information about nodes like so:

    curl 'http://localhost:8080/pdb/query/v4/environments/production'

    {
      "name" : "production"
    }

## `/pdb/query/v4/environments/<ENVIRONMENT>/[events|facts|reports|resources]`

These routes are identical to issuing a request to
`/pdb/query/v4/[events|facts|reports|resources]`, with a query
parameter of `["=","environment","<ENVIRONMENT>"]`. All query
parameters and route suffixes from the original routes are
supported. The result format is also the same. Additional query
parameters are ANDed with the environment clause. See
[/pdb/query/v4/events][events], [/pdb/query/v4/facts][facts],
[/pdb/query/v4/reports][reports] or
[/pdb/query/v4/resources][resources] for more info.

## Paging

This query endpoint supports paged results via the common PuppetDB paging
URL parameters.  For more information, please see the documentation
on [paging][paging].
