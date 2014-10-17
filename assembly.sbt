import AssemblyKeys._ // put this at the top of the file

assemblySettings

// your assembly settings here

assemblyOption in assembly ~= { _.copy(prependShellScript = Some(defaultShellScript)) }

jarName in assembly := { s"${name.value}-${version.value}" }
