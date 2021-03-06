---
title: "PuppetDB 3.2 » Overview"
layout: default
canonical: "/puppetdb/latest/index.html"
---

[exported]: /puppet/latest/reference/lang_exported.html
[connect]: ./connect_puppet_master.html
[apply]: ./connect_puppet_apply.html
[install_via_module]: ./install_via_module.html
[install_from_packages]: ./install_from_packages.html
[install_advanced]: ./install_from_source.html
[scaling]: ./scaling_recommendations.html
[facts]: /puppet/latest/reference/lang_facts_and_builtin_vars.html
[catalog]: /puppet/latest/reference/lang_summary.html#compilation-and-catalogs
[releasenotes]: ./release_notes.html
[github]: https://github.com/puppetlabs/puppetdb
[tracker]: https://tickets.puppetlabs.com/browse/PDB
[migrating]: ./migrate.html
[old_docs]: http://docs.puppetlabs.com/puppetdb/1.1/

PuppetDB collects data generated by Puppet. It enables advanced Puppet features like [exported resources][exported], and can be the foundation for other applications that use Puppet's data.

Install It Now
-----

To start using PuppetDB today:

* Review [the system requirements below](#system-requirements) (and, optionally, [our scaling recommendations][scaling]).
* Choose your installation method:
    * [easy install][install_via_module] using the PuppetDB puppet module on our recommended platforms
    * [install from packages][install_from_packages] on our recommended platforms
    * [advanced install][install_advanced] on any other \*nix.

Version Note
-----

This manual covers the 3.2.x series of PuppetDB releases, which is
a backward-compatible feature release following the 3.1.x series.

[See the release notes][releasenotes] for information on all
changes.


What Data?
-----

PuppetDB stores:

* The most recent [facts][] from every node
* The most recent [catalog][] for every node
* Optionally, fourteen days (configurable) of event reports for every node

Together, these give you a huge inventory of metadata about every node in your infrastructure and a searchable database of **every single resource** being managed on any node.

Puppet itself can search a subset of this data using [exported resources][exported], which allow nodes to manage resources on other nodes. This is similar to the capabilities of the legacy ActiveRecord `storeconfigs` interface, but much, much faster. The remaining data is available through PuppetDB's query APIs (see navigation sidebar for details).

System Requirements
-----

### \*nix Server with JDK 1.7+ (Debian) or JDK 1.8+ (RHEL-derived)

#### Standard Install: RHEL, CentOS, Debian, and Ubuntu

Puppet Labs provides packages and a Puppet module for PuppetDB which simplify setup of its SSL certificates and init scripts. These packages are available for the following operating systems:

* Red Hat Enterprise Linux 6.6+ and 7 (and any derived distro that includes Java 1.8)
* Debian 7 (Wheezy) and 8 (Jessie)
* Ubuntu 12.04 LTS, 14.04 LTS

[See here for instructions for installing via the PuppetDB puppet module.][install_via_module]

[See here for instructions for installing from OS packages.][install_from_packages]

#### Custom Install: Any Unix-like OS

If you're willing to do some manual configuration, PuppetDB can run on any Unix-like OS with JDK 1.7 or higher, including:

* Recent MacOS X versions (using built-in Java 1.8 support)
* Nearly any Linux distribution (using Java 1.8)
* Nearly any \*nix system running a recent Oracle-provided 1.8 JDK

[See here for advanced installation instructions.][install_advanced]

### Puppet 4.0.0

Your site's Puppet masters must be running Puppet 4.0.0 or
later. [You will need to connect your puppet masters to PuppetDB after installing it][connect].
If you wish to use PuppetDB with
[standalone nodes that are running puppet apply][apply], every node
must be running 3.8.1 or later.

> #### Note about Puppet Enterprise
> * PuppetDB has been included in Puppet Enterprise since 3.0.0. Users of Puppet
Enterprise 2.8 and below can use PuppetDB 1.1 as a separate package, and should
visit the [PuppetDB 1.1 documentation][old_docs].

### Robust Hardware

PuppetDB will be a critical component of your Puppet deployment and so should be run on a robust and reliable server.

However, it can do a lot with fairly modest hardware: in benchmarks using real-world catalogs from a customer, a single 2012 laptop (16 GB of RAM, consumer-grade SSD, and quad-core processor) running PuppetDB and PostgreSQL was able to keep up with sustained input from 8,000 simulated Puppet nodes checking in every 30 minutes. Powerful server-grade hardware will perform even better.

The actual requirements will vary wildly depending on your site's size and characteristics. At smallish sites, you may even be able to run PuppetDB on your puppet master server.

For more on fitting PuppetDB to your site, [see "Scaling Recommendations."][scaling]

Open Source
-----

PuppetDB is developed openly, and is released under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html). You can get the source --- and contribute to it! --- at [the PuppetDB GitHub repo][github]. Bugs and feature requests are welcome at [Puppet Labs's issue tracker][tracker].
